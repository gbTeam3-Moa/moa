const textareas = document.querySelectorAll(".moa-textarea");
const postContent = document.querySelector("#content-textarea");
const wordLength = document.querySelector(".word-length");
const helpText = document.querySelector(".help-text");
const maxWordLength = 5000;
const saveButton = document.querySelector(".save-button");

// 게시글의 현재 글자수 및 최대 글자수 안내
helpText.innerText = `${maxWordLength}자 이내로 작성해주세요.`;
wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;

postContent.addEventListener("focus", (e) => {
    wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;
});

postContent.addEventListener("keyup", (e) => {
    wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;
});

postContent.addEventListener("blur", (e) => {
    wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;
});

// 게시글 저장버튼에 입력된 정보 저장 기능 추가
saveButton.addEventListener("click", (e) => {
    // 여기서 저장 기능 구현
});

textareas.forEach((textarea) => {
    let focusCheck = false;
    textarea.addEventListener("mouseenter", (e) => {
        e.target.parentElement.classList.add("textarea-border-changed");
    });

    textarea.addEventListener("mouseleave", (e) => {
        if (!focusCheck) {
            e.target.parentElement.classList.remove("textarea-border-changed");
        }
    });

    textarea.addEventListener("focus", (e) => {
        focusCheck = true;
        e.target.parentElement.classList.add("textarea-border-changed");
    });

    textarea.addEventListener("blur", (e) => {
        focusCheck = false;
        e.target.parentElement.classList.remove("textarea-border-changed");
    });
});
