addEventListener("DOMContentLoaded", () => {
  const list_table = document.querySelector("table.main.list");

  const trClickHandler = (e) => {
    const td = e.target;

    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const id = tr.dataset.id;
      document.location.href = `${rootPath}/books/detail?id=${id}`;
    }
  };

  list_table.addEventListener("click", trClickHandler);
});
