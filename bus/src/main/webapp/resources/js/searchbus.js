document.addEventListener("DOMContentLoaded", () => {
  const select1 = document.getElementById("select1");
  const select2 = document.getElementById("select2");
  const mainviewForm = document.getElementById("mainview");

  const stopAni_str = document.getElementById("stop-image-str");
  const stopAni_end = document.getElementById("stop-image-end");
  const moveAni = document.getElementById("moving-image");

  const inputDepTer = async () => {
    let depValue = select1.value;
    // 컨트롤러에게 DepValue 값 보내고 select2 에 옵션추가
    // rootPath 변수 추가해줘야됨
    while (select2.options.length > 1) {
      select2.removeChild(select2.lastChild);
    }
    const url = `${rootPath}/searchbus/loadArrTer?depTerId=${depValue}`;
    if (depValue !== "str_default") {
      const response = await fetch(url);
      const result = await response.json();
      console.log(result);
      result.forEach((depTer) => {
        // 새로운 옵션을 생성
        const newOption = document.createElement("option");
        newOption.value = `${depTer.terId}`; // 새로운 옵션의 값 설정
        newOption.textContent = `${depTer.terName}`; // 새로운 옵션의 텍스트 설정

        // 새로운 옵션을 select 요소에 추가
        select2.appendChild(newOption);
      });
    }
  };

  const inputDepTerAndArrTer = async () => {
    if (select1.value !== "str_default" && select2.value !== "end_default") {
      //   console.log("출발 정류장 ID : " + select1.value);
      //   const selectedOption1 = select1.options[select2.selectedIndex];
      //   console.log("출발 정류장 이름 : " + selectedOption1.textContent);

      //   console.log("도착 정류장 ID : " + select2.value);
      //   const selectedOption2 = select2.options[select2.selectedIndex];
      //   console.log("도착 정류장 이름 : " + selectedOption2.textContent);
      mainviewForm.style.display = "flex";

      const title_left = document.getElementById("title_left");
      const title_right = document.getElementById("title_right");

      title_left.textContent =
        select1.options[select1.selectedIndex].textContent;
      title_right.textContent =
        select2.options[select2.selectedIndex].textContent;

      const depValue = select1.value;
      const arrValue = select2.value;

      const url = `${rootPath}/searchbus/loadSchedule?depTerId=${depValue}&arrTerId=${arrValue}`;
      const response = await fetch(url);
      const result = await response.json();
      // result 로 화면그리기, 출발시간 + 소요시간 = 도착시간 계산
      const list = document?.getElementById("list");

      const list_index_body =
        document?.getElementsByClassName("list_index_body");
      for (var i = 0; i < list_index_body.length; i++) {
        var section = list_index_body.item(i);
        section.remove();
      }

      result.forEach((drive) => {
        const schedules = drive.td_schedule;
        schedules.forEach((schedule) => {
          const divElement = document?.createElement("div");
          divElement.classList.add("list_index_body");

          // 새로운 span 요소들을 생성하고 내용을 설정
          const span1 = document.createElement("span");
          span1.textContent = `${schedule.tes_Schedule}`;

          const span2 = document.createElement("span");
          span2.textContent = returnArrTime(
            `${schedule.tes_Schedule}`,
            `${drive.td_WasteTime}`
          );

          const span3 = document.createElement("span");
          span3.textContent = `${drive.td_Fare}`;

          const span4 = document.createElement("span");
          span4.textContent = "O";

          // 생성한 span 요소들을 div 요소에 추가
          divElement.appendChild(span1);
          divElement.appendChild(span2);
          divElement.appendChild(span3);
          divElement.appendChild(span4);

          // 생성한 div 요소를 list_body 요소에 추가
          list.appendChild(divElement);
        });
      });
    }
  };

  // 유효성 검사 및 애니매이션 재생
  function handleChange() {
    if (select1.value === "str_default") {
      alert("첫 번째 선택지를 먼저 선택해주세요.");
      mainviewForm.style.display = "none";

      return false;
    }

    if (select1.value !== "str_default" && select2.value !== "end_default") {
      mainviewForm.style.display = "flex";

      stopAni_str.style.display = "flex";
      stopAni_end.style.display = "flex";
      moveAni.style.display = "flex";

      stopAni_str.style.animationPlayState = "running";
      stopAni_end.style.animationPlayState = "running";
      moveAni.style.animationPlayState = "running";
    } else {
      mainviewForm.style.display = "none";

      stopAni_str.style.display = "none";
      stopAni_end.style.display = "none";
      moveAni.style.display = "none";

      stopAni_str.style.animationPlayState = "paused";
      stopAni_end.style.animationPlayState = "paused";
      moveAni.style.animationPlayState = "paused";
    }
  }

  // 도착시간 처리 함수
  function returnArrTime(depTime, durTime) {
    const [depHour, depMin] = depTime.split(":").map(Number);

    // time2가 "HH:mm" 형식이 아닌 경우, 분 단위로 가정
    let durMin = Number(durTime);
    let durHour = Math.floor(durMin / 60);
    durMin %= 60;

    const totalMinute = (depHour + durHour) * 60 + depMin + durMin;

    const hours = String(Math.floor(totalMinute / 60)).padStart(2, "0");
    const minutes = String(totalMinute % 60).padStart(2, "0");
    const resultTimeString = `${hours}:${minutes}`;

    return resultTimeString;
  }

  select1.addEventListener("change", handleChange);
  select1.addEventListener("change", inputDepTer);
  select2.addEventListener("change", handleChange);
  select2.addEventListener("change", inputDepTerAndArrTer);
});
