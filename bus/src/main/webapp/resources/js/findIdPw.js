const INPUT_INDEX = {
  NAME: 0,
  PHONE: 1,
  MAIL: 2,
  PW_PHONE: 3,
};

// document.addEventListener("DOMContentLoaded", () => {
//   const find1 = () => {
//     const find_inputs = document.querySelectorAll(".wrapper input");
//     if (!find_inputs[INPUT_INDEX.NAME].value) {
//       alert("이름은 필수 항목입니다");
//       find_inputs[INPUT_INDEX.NAME].focus();
//       return false;
//     }
//     if (!find_inputs[INPUT_INDEX.PHONE].value) {
//       alert("휴대폰 번호는 필수 항목입니다");
//       find_inputs[INPUT_INDEX.PHONE].focus();
//       return false;
//     }

//     // document.querySelector("form#USER").submit();
//     // alert(document.getElementById);
//   };
//   const find2 = () => {
//     const find_inputs = document.querySelectorAll(".wrapper input");
//     if (!find_inputs[INPUT_INDEX.MAIL].value) {
//       alert("이메일을 입력해주세요");
//       find_inputs[INPUT_INDEX.MAIL].focus();
//       return false;
//     }
//     if (!find_inputs[INPUT_INDEX.PW_NAME].value) {
//       alert("이름을 입력해주세요");
//       find_inputs[INPUT_INDEX.PW_NAME].focus();
//       return false;
//     }
//     if (!find_inputs[INPUT_INDEX.PW_PHONE].value) {
//       alert("휴대폰 번호는 필수 항목입니다");
//       find_inputs[INPUT_INDEX.PW_PHONE].focus();
//       return false;
//     }
//     alert("찾으시는 비밀번호는 ~~ 입니다");
//   };

//   document.querySelector("#find_button1").addEventListener("click", find1);
//   document.querySelector("#find_button2").addEventListener("click", find2);
// });

// 잠시만 라인그어보자

document.addEventListener("DOMContentLoaded", () => {
  const find_id = () => {
    const find_inputs = document.querySelectorAll(".findID input");
    if (!find_inputs[INPUT_INDEX.NAME].value) {
      alert("이름은 필수 항목입니다");
      find_inputs[INPUT_INDEX.NAME].focus();
      return false;
    }
    if (!find_inputs[INPUT_INDEX.PHONE].value) {
      alert("휴대폰 번호는 필수 항목입니다");
      find_inputs[INPUT_INDEX.PHONE].focus();
      return false;
    }

    document.querySelector("form.findID").submit();
  };

  const find_pw = () => {
    const find_inputs2 = document.querySelectorAll(".findPW input");
    if (!find_inputs2[INPUT_INDEX.MAIL].value) {
      alert("이메일을 입력해주세요");
      find_inputs2[INPUT_INDEX.MAIL].focus();
      return false;
    }
    if (!find_inputs2[INPUT_INDEX.PW_PHONE].value) {
      alert("휴대폰 번호는 필수 항목입니다");
      find_inputs2[INPUT_INDEX.PW_PHONE].focus();
      return false;
    }

    document.querySelector("form.findPW").submit();
  };

  document.querySelector("#find_button1").addEventListener("click", find_id);
  document.querySelector("#find_button2").addEventListener("click", find_pw);
});
