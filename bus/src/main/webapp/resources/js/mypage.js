document.addEventListener("DOMContentLoaded", () => {
  const db_btn = document.getElementById("db_btn");
  const mypage = document.getElementById("mypage");
  const db_event = async () => {
    const url = `${rootPath}/mypage/savedb`;
    const response = await fetch(url);
    const result = await response.json();
    const message = result.message;
    db_btn.style.display = "none";

    const divElement = document.createElement("div");
    divElement.classList.add("message_box");
    divElement.textContent = message;
    mypage.appendChild(divElement);
  };
  db_btn.addEventListener("click", db_event);
});
