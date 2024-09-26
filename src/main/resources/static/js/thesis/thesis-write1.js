const textareas = document.querySelectorAll(".moa-textarea");
const postContent = document.querySelector("#content-textarea");
const wordLength = document.querySelector(".word-length");
const helpText = document.querySelector(".help-text");
const maxWordLength = 5000;
const attachInputs = document.querySelectorAll(".attach-input");
const saveButton = document.querySelector(".save-button");
let i = 0;

// 게시글의 현재 글자수 및 최대 글자수 안내
// 게시글 좌측 하단 - 최대 글자수 안내
helpText.innerText = `${maxWordLength}자 이내로 작성해주세요.`;
// 게시글 우측 하단 - 현재 글자수 / 최대 글자수
wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;
// focus를 받자마자 0이 된 글자수 반영
postContent.addEventListener("focus", (e) => {
    wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;
});
// 입력되는 글자수를 실시간으로 반영
postContent.addEventListener("keyup", (e) => {
    wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;
});
// focus를 잃었을 때까지 입력된 글자수 반영
postContent.addEventListener("blur", (e) => {
    wordLength.innerText = `${postContent.value.length}/${maxWordLength}`;
});

// 첨부파일 목록 관리
attachInputs.forEach((attachInput) => {
    // 첨부파일 버튼이 클릭되어 attachInput에 file이 입력되었을 때
    attachInput.addEventListener("change", (e) => {
        // 파일 정보 불러오기
        const [file] = e.target.files;
        const reader = new FileReader();
        reader.readAsDataURL(file);
        // 첨부파일 객체 생성
        const attachFile = `<div class="attach-file">
                                <label>
                                        <div class="attach-cancel-button" id=attach-cancel-button-${++i}></div>
                                        <input type="file" id=attach-info-${i} disabled/>
                                </label>
                                <div class="thumbnail-wrap white-box">
                                    <div class="thumbnail" id=thumbnail-${i}></div>
                                </div>
                                <div class="attach-text-wrap">${file.name}</div>
                            </div>`;
        const attachButtonFileWrap =
            attachInput.parentElement.parentElement.parentElement;
        const attachButton = attachButtonFileWrap.firstElementChild;
        attachButtonFileWrap.innerHTML += attachFile;
        // attachInput에 담긴 파일 정보를 첨부파일 객체의 files에 추가
        const attachInfo = document.querySelector(`#attach-info-${i}`);
        const dataTransfer = new DataTransfer();
        dataTransfer.items.add(file);
        attachInfo.files = dataTransfer.files;
        // attachInput에 담긴 파일 정보 삭제 및 attachButton 삭제
        attachInput.value = "";
        attachButtonFileWrap.removeChild(
            attachButtonFileWrap.firstElementChild
        );
        // 첨부파일 삭제버튼 및 입력된 첨부파일의 종류에 따른 썸네일 생성
        reader.addEventListener("load", (e) => {
            const thumbnailUnique = document.querySelector(`#thumbnail-${i}`);
            const attachCancelButtonUnique = document.querySelector(
                `#attach-cancel-button-${i}`
            );
            const path = e.target.result;
            // 이미지 파일 썸네일 생성
            if (path.includes("image")) {
                thumbnailUnique.style.backgroundImage = `url(${path})`;
                attachCancelButtonUnique.style.display = "block";
                //  기타 파일은 빈 썸네일
            } else {
                thumbnailUnique.style.backgroundImage = "";
                attachCancelButtonUnique.style.display = "block";
            }
        });
        // 모든 첨부파일의 삭제버튼에 해당 파일 삭제기능 추가
        const attachCancelButton = document.querySelector(
            `#attach-cancel-button-${i}`
        );
        attachCancelButton.addEventListener("click", (e) => {
            // 첨부파일 목록에서 해당 파일 삭제
            attachInfo.value = "";
            attachButtonFileWrap.appendChild(attachButton);
            attachButtonFileWrap.removeChild(
                attachButtonFileWrap.firstElementChild
            );
        });
    });
});

// 게시글 저장버튼에 입력된 정보 저장 기능 추가
// saveButton.addEventListener("click", (e) => {});

textareas.forEach((textarea) => {
    let value = textarea.value;
    let focusCheck = false;
    textarea.addEventListener("mouseenter", (e) => {
        e.target.parentElement.classList.add("textarea-border-changed");
        e.target.parentElement.classList.remove("textarea-border");
    });

    textarea.addEventListener("mouseleave", (e) => {
        if (focusCheck) {
            e.target.parentElement.classList.add("textarea-border-changed");
            e.target.parentElement.classList.remove("textarea-border");
        } else {
            e.target.parentElement.classList.add("textarea-border");
            e.target.parentElement.classList.remove("textarea-border-changed");
        }
    });

    textarea.addEventListener("focus", (e) => {
        focusCheck = true;
        if (
            e.target.parentElement.classList.contains("textarea-border-changed")
        ) {
            e.target.parentElement.classList.add("textarea-border-changed");
            e.target.parentElement.classList.remove("textarea-border");
        } else {
            e.target.parentElement.classList.add("textarea-border");
            e.target.parentElement.classList.remove("textarea-border-changed");
        }
    });

    textarea.addEventListener("blur", (e) => {
        focusCheck = false;
        if (
            !e.target.parentElement.classList.contains(
                "textarea-border-changed"
            )
        ) {
            e.target.parentElement.classList.add("textarea-border-changed");
            e.target.parentElement.classList.remove("textarea-border");
        } else {
            e.target.parentElement.classList.add("textarea-border");
            e.target.parentElement.classList.remove("textarea-border-changed");
        }
    });
});
const thesisWrite1 = () => {
    let text = ``;

    text += `
        <div class="post-write-form">
            <form>
                <div class="post-write-form-section">
                    <div class="form-section-header">
                        <p class="form-section-title subtitle-1">
                            논문 공고 작성
                        </p>
                    </div>
                    <div class="form-input-section">
                        <div class="form-part">
                            <label class="form-title font-body-1-bold">
                                학교 및 전공
                            </label>
                            <div class="mb8"></div>
                            <div class="form-content">
                                <div class="content-textarea">
                                    <div class="textarea-border">
                                        <textarea class="moa-textarea font-body-2 text6" name="school-major" id="school-major-textarea"
                                            maxlength="70" rows="1" style="width: 100%; min-height: 30px;" placeholder="현재 소속된 학교와 교수님 본인의 전공을 입력해주세요. ex) 모아대학교, 천체물리학"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-part">
                            <label class="form-title font-body-1-bold">
                                프로젝트 분야
                            </label>
                            <div class="mb8"></div>
                            <div class="form-content">
                                <div class="content-textarea">
                                    <div class="textarea-border">
                                        <textarea class="moa-textarea font-body-2 text6" name="project-field" id="project-field-textarea"
                                            maxlength="70" rows="1" style="width: 100%; min-height: 30px;" placeholder="진행할 프로젝트 분야를 입력해 주세요. ex) IT / 네트워크"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-part">
                            <label class="form-title font-body-1-bold">
                                프로젝트 제목
                                <span class="required">*</span>
                            </label>
                            <div class="mb8"></div>
                            <div class="form-content">
                                <div class="content-textarea">
                                    <div class="textarea-border">
                                        <textarea class="moa-textarea font-body-2 text6" name="project-title" id="title-textarea"
                                            maxlength="206" rows="3" style="width: 100%; min-height: 30px;" placeholder="프로젝트 제목을 입력해주세요. ex) 삼성 반도체 건설 안전 관리 회사 웹사이트 구축"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-part">
                            <label class="form-title font-body-1-bold">
                                예상 금액
                            </label>
                            <div class="mb8"></div>
                            <div class="form-content">
                                <div class="content-textarea">
                                    <div class="textarea-border">
                                        <textarea class="moa-textarea font-body-2 text6" name="estimated-price" id="price-textarea"
                                            maxlength="70" rows="1" style="width: 100%; min-height: 30px;" placeholder="예상금액을 입력해주세요. ex) 5,000,000원"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-part">
                            <label class="form-title font-body-1-bold">
                                예상 기간
                            </label>
                            <div class="mb8"></div>
                            <div class="form-content">
                                <div class="content-textarea">
                                    <div class="textarea-border">
                                        <textarea class="moa-textarea font-body-2 text6" name="estimated-duration" id="duration-textarea"
                                            maxlength="70" rows="1" style="width: 100%; min-height: 30px;" placeholder="예상기간을 입력해 주세요. ex) 30일"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-part">
                            <label class="form-title font-body-1-bold">
                                모집 마감일
                                <span class="required">*</span>
                            </label>
                            <div class="mb8"></div>
                            <div class="form-content">
                                <div class="content-textarea">
                                    <div class="textarea-border">
                                        <textarea class="moa-textarea font-body-2 text6" name="deadline" id="deadline-textarea"
                                            maxlength="70" rows="1" style="width: 100%; min-height: 30px;" placeholder="모집 마감일을 입력해주세요. ex) 2024년 11월 11일"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-part">
                            <label class="form-title font-body-1-bold">
                                예상 시작일
                                <span class="required">*</span>
                            </label>
                            <div class="mb8"></div>
                            <div class="form-content">
                                <div class="content-textarea">
                                    <div class="textarea-border">
                                        <textarea class="moa-textarea font-body-2 text6" name="start-date" id="start-date-textarea"
                                            maxlength="70" rows="1" style="width: 100%; min-height: 30px;" placeholder="예상 시작일을 입력해주세요. ex) 2024년 06월 01일"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="complete-save-button-divider">
                        <div class="complete-button">작성완료</div>
                        <div class="save-button">저장</div>
                    </div>
                </div>
            </form>
        </div>
    `;


    writediv.innerHTML = text;
}

