/*
==========================================
THE ADVERTISERS
Enquiries Module
==========================================
*/

let originalRows = [];
let filteredRows = [];

let currentPage = 1;
let rowsPerPage = 10;
let sortDirection = 1;

/* ==========================================
    Init
========================================== */

document.addEventListener("DOMContentLoaded", () => {

    initTable();

});

/* ==========================================
    Table Init
========================================== */

function initTable() {

    const tbody = document.getElementById("tableBody");

    if (!tbody) return;

    originalRows = Array.from(
        tbody.querySelectorAll("tr:not(#noResultsRow)")
    );

    filteredRows = [...originalRows];

    updateTable();

}

/* ==========================================
    Search
========================================== */

function filterTable() {

    const keyword = document
        .getElementById("searchInput")
        .value
        .toLowerCase();

    if (keyword === "") {

        filteredRows = [...originalRows];

    } else {

        filteredRows = originalRows.filter(row =>
            row.innerText.toLowerCase().includes(keyword)
        );

    }

    currentPage = 1;

    updateTable();

}

/* ==========================================
    Sort
========================================== */

function sortTable(index) {

    sortDirection *= -1;

    filteredRows.sort((a, b) => {

        let x = a.cells[index].innerText.toLowerCase();

        let y = b.cells[index].innerText.toLowerCase();

        if (x < y) return -1 * sortDirection;
        if (x > y) return 1 * sortDirection;

        return 0;

    });

    updateTable();

}

/* ==========================================
    Page Size
========================================== */

function changePageSize() {

    rowsPerPage = parseInt(
        document.getElementById("rowsPerPage").value
    );

    currentPage = 1;

    updateTable();

}

/* ==========================================
    Previous
========================================== */

function prevPage() {

    if (currentPage > 1) {

        currentPage--;

        updateTable();

    }

}

/* ==========================================
    Next
========================================== */

function nextPage() {

    const max = Math.ceil(filteredRows.length / rowsPerPage);

    if (currentPage < max) {

        currentPage++;

        updateTable();

    }

}

/* ==========================================
    Update Table
========================================== */

function updateTable() {

    const tbody = document.getElementById("tableBody");

    const noData = document.getElementById("noResultsRow");

    tbody.innerHTML = "";

    if (filteredRows.length === 0) {

        tbody.appendChild(noData);

        noData.classList.remove("hidden");

        document.getElementById("startRow").innerText = 0;
        document.getElementById("endRow").innerText = 0;
        document.getElementById("totalRows").innerText = 0;

        return;

    }

    noData.classList.add("hidden");

    const start = (currentPage - 1) * rowsPerPage;

    const end = Math.min(start + rowsPerPage, filteredRows.length);

    filteredRows
        .slice(start, end)
        .forEach(row => tbody.appendChild(row));

    document.getElementById("startRow").innerText = start + 1;

    document.getElementById("endRow").innerText = end;

    document.getElementById("totalRows").innerText =
        filteredRows.length;

    document.getElementById("prevBtn").disabled =
        currentPage === 1;

    document.getElementById("nextBtn").disabled =
        currentPage ===
        Math.ceil(filteredRows.length / rowsPerPage);

}

/* ==========================================
    Modal
========================================== */

function openReportModal(btn) {

    document.getElementById("modalService").innerText =
        btn.dataset.service || "General Inquiry";

    document.getElementById("modalName").innerText =
        btn.dataset.name;

    document.getElementById("modalEmail").innerText =
        btn.dataset.email;

    document.getElementById("modalPhone").innerText =
        btn.dataset.phone || "-";

    document.getElementById("modalDate").innerText =
        btn.dataset.date;

    document.getElementById("modalMessage").innerText =
        btn.dataset.message;

    document.getElementById("modalReplyBtn").href =
        "mailto:" + btn.dataset.email;

    document
        .getElementById("reportModal")
        .classList.remove("hidden");

}

/* ==========================================
    Close Modal
========================================== */

function closeReportModal() {

    document
        .getElementById("reportModal")
        .classList.add("hidden");

}

/* ==========================================
    ESC Close
========================================== */

document.addEventListener("keydown", e => {

    if (e.key === "Escape") {

        closeReportModal();

    }

});

/* ==========================================
    Click Outside
========================================== */

window.addEventListener("click", function(e){

    const modal = document.getElementById("reportModal");

    if(e.target === modal){

        closeReportModal();

    }

});