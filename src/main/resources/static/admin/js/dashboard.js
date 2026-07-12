/*
==========================================
THE ADVERTISERS
Premium Dashboard
==========================================
*/

document.addEventListener("DOMContentLoaded", () => {

    setGreeting();
    animateCounters();
    initSidebar();
    initCards();

});

/* ==========================================
   Greeting
========================================== */

function setGreeting() {

    const greeting = document.getElementById("greeting");

    if (!greeting) return;

    const hour = new Date().getHours();

    let text = "Good Evening";

    if (hour < 12) {

        text = "Good Morning";

    } else if (hour < 17) {

        text = "Good Afternoon";

    }

    greeting.innerHTML =
        `${text}, <span class="text-white font-bold">Administrator 👋</span>`;

}

/* ==========================================
   Counter Animation
========================================== */

function animateCounters() {

    const counters = document.querySelectorAll(".counter");

    counters.forEach(counter => {

        const target = parseInt(counter.innerText);

        let count = 0;

        const speed = Math.max(1, Math.floor(target / 50));

        const timer = setInterval(() => {

            count += speed;

            if (count >= target) {

                count = target;

                clearInterval(timer);

            }

            counter.innerText = count;

        }, 20);

    });

}

/* ==========================================
   Sidebar Toggle (Mobile)
========================================== */

function initSidebar() {

    const menuBtn = document.getElementById("menuBtn");
    const sidebar = document.getElementById("sidebar");

    if (!menuBtn || !sidebar) return;

    menuBtn.addEventListener("click", () => {

        sidebar.classList.toggle("-translate-x-full");

    });

}

/* ==========================================
   Card Hover Effect
========================================== */

function initCards() {

    const cards = document.querySelectorAll(".dashboard-card");

    cards.forEach(card => {

        card.addEventListener("mouseenter", () => {

            card.style.transform = "translateY(-8px) scale(1.02)";

        });

        card.addEventListener("mouseleave", () => {

            card.style.transform = "translateY(0px) scale(1)";

        });

    });

}

/* ==========================================
   Current Date
========================================== */

(function () {

    const date = document.getElementById("currentDate");

    if (!date) return;

    const options = {

        weekday: "long",
        year: "numeric",
        month: "long",
        day: "numeric"

    };

    date.innerText =
        new Date().toLocaleDateString("en-IN", options);

})();

/* ==========================================
   Notification Badge Animation
========================================== */

(function () {

    const badge = document.getElementById("notificationBadge");

    if (!badge) return;

    setInterval(() => {

        badge.classList.toggle("scale-125");

    }, 1000);

})();