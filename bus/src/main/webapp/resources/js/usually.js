document.addEventListener("DOMContentLoaded", () => {
  const trClickHandler = (e) => {
    const target = e.target;
    if (target.tagName == "TD") {
      const tr = target.closest("TR");
      const stcode = tr.dataset.stcode;
      const etcode = tr.dataset.etcode;
      document.location.href = `${rootPath}/searchbus?scode=${stcode}&ecode=${etcode}`;
    }
  };
  const us_table = document.querySelector("table.us.table");
  us_table.addEventListener("click", trClickHandler);
});
