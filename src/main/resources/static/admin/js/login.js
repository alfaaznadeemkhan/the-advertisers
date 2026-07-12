/*
====================================================
THE ADVERTISERS
Premium Login JS
====================================================
*/

document.addEventListener("DOMContentLoaded", () => {

    initPasswordToggle();
    initInputEffects();
    initFormSubmit();

});

/* ==========================================
   Password Show / Hide
========================================== */

function initPasswordToggle() {

    const password = document.getElementById("password");
    const toggle = document.getElementById("togglePassword");
    const icon = document.getElementById("toggleIcon");

    if (!password || !toggle || !icon) return;

    toggle.addEventListener("click", function () {

        if (password.type === "password") {

            password.type = "text";

            icon.classList.remove("fa-eye");
            icon.classList.add("fa-eye-slash");

        } else {

            password.type = "password";

            icon.classList.remove("fa-eye-slash");
            icon.classList.add("fa-eye");

        }

    });

}

/* ==========================================
   Input Focus Animation
========================================== */

function initInputEffects() {

    const inputs = document.querySelectorAll(".input");

    inputs.forEach(input => {

        input.addEventListener("focus", function () {

            this.parentElement.classList.add("active");

        });

        input.addEventListener("blur", function () {

            if (this.value.trim() === "") {

                this.parentElement.classList.remove("active");

            }

        });

    });

}

/* ==========================================
   Login Button Loading
========================================== */

function initFormSubmit() {

    const form = document.getElementById("loginForm");

    if (!form) return;

    form.addEventListener("submit", function () {

        const btn = document.getElementById("loginButton");

        if (!btn) return;

        btn.disabled = true;

        btn.innerHTML = `
            <i class="fa-solid fa-spinner fa-spin"></i>
            Signing In...
        `;

    });

}

/* ==========================================
   Press Enter Support
========================================== */

document.addEventListener("keypress", function (e) {

    if (e.key === "Enter") {

        const form = document.getElementById("loginForm");

        if (form) {

            form.requestSubmit();

        }

    }

});