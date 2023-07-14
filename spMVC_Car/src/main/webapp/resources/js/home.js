document.addEventListener("DOMContentLoaded", () => {
  const list_table = document.querySelector("table.main.list");

  const trClickHandler = (e) => {
    // table > tr 을 클릭했을때 최종적으로 클릭되는 요소는 TD 이다
    // 최종적으로 클릭되는 요소를 e.target 이라고 한다
    const td = e.target;

    // 최종적으로 클릭된 요소가 TD 인가를 확인하고
    if (td.tagName === "TD") {
      // td. closest
      // td를 감싸고 있는 TR 중에서 가장 가까운 tag
      const tr = td.closest("TR");
      // data-id 속성에 설정된 값을 가져오기
      const id = tr.dataset.id;
      //   document.location.href = `${rootPath}/edit?id=${id}`;
      document.location.href = `/car/edit?id=${id}`;
    }
  };

  list_table?.addEventListener("click", trClickHandler);
});
