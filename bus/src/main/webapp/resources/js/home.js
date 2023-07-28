document.addEventListener("DOMContentLoaded", () => {
  const circles = document.querySelectorAll(".circle"); //[7]
  let activeLight = 0; //[8]
  setInterval(changeLight, 1000);

  function changeLight() {
    circles[activeLight].className = "circle"; // [10] remove init color
    activeLight++;

    if (activeLight > 2) {
      activeLight = 0;
    }

    const currentLight = circles[activeLight]; //[11]
    currentLight.classList.add(currentLight.getAttribute("color")); //[12], [13]
  }
});
