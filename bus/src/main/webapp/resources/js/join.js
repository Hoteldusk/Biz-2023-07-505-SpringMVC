document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form.join");
  const id = form?.querySelector("input.id");
  const pwd1 = form?.querySelector("input.pwd1");
  const pwd2 = form?.querySelector("input.pwd2");
  const name = form?.querySelector("input.name");
  const tel = form?.querySelector("input.tel");
  const form_btn = form?.querySelector("input.submitBtn");

  const form_check = (e) => {
    if (!id.value) {
      alert("ID를 입력하세요.");
      id.focus();
      e.preventDefault();
      return false;
    }

    if (!pwd1.value) {
      alert("비밀번호를 입력하세요.");
      pwd1.focus();
      e.preventDefault();
      return false;
    }
    if (!pwd2.value) {
      alert("비밀번호 확인란을 입력하세요.");
      pwd2.focus();
      e.preventDefault();
      return false;
    }

    if (!name.value) {
      alert("이름을 입력하세요.");
      name.focus();
      e.preventDefault();
      return false;
    }
    if (!tel.value) {
      alert("전화번호를 입력하세요.");
      tel.focus();
      e.preventDefault();
      return false;
    }
    if (pwd1.value !== pwd2.value) {
      alert("비밀번호가 같지 않습니다. 비밀번호를 다시 입력해주세요.");
      pwd1.focus();
      pwd1.value = "";
      pwd2.value = "";
      e.preventDefault();
      return false;
    }
    form?.submit();
  };

  form_btn?.addEventListener("click", form_check);

  const home = document.querySelector("h1.home");
  home?.addEventListener("click", () => {
    location.href = "/bus";
  });
});
