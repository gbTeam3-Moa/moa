const textareas = document.querySelectorAll(".moa-textarea");

const postContent1 = document.querySelector("#content-textarea1");
const wordLength1 = document.querySelector(".word-length1");
const helpText1 = document.querySelector(".help-text1");

const postContent2 = document.querySelector("#content-textarea2");
const wordLength2 = document.querySelector(".word-length2");
const helpText2 = document.querySelector(".help-text2");

const maxWordLength = 5000;
const attachInputs = document.querySelectorAll(".attach-input");
const saveButton = document.querySelector(".save-button");
let i = 0;

// 게시글의 현재 글자수 및 최대 글자수 안내
// 게시글 좌측 하단 - 최대 글자수 안내
helpText1.innerText = `${maxWordLength}자 이내로 작성해주세요.`;
// 게시글 우측 하단 - 현재 글자수 / 최대 글자수
wordLength1.innerText = `${postContent1.value.length}/${maxWordLength}`;
// focus를 받자마자 0이 된 글자수 반영
postContent1.addEventListener("focus", (e) => {
    wordLength1.innerText = `${postContent1.value.length}/${maxWordLength}`;
});
// 입력되는 글자수를 실시간으로 반영
postContent1.addEventListener("keyup", (e) => {
    wordLength1.innerText = `${postContent1.value.length}/${maxWordLength}`;
});
// focus를 잃었을 때까지 입력된 글자수 반영
postContent1.addEventListener("blur", (e) => {
    wordLength1.innerText = `${postContent1.value.length}/${maxWordLength}`;
});

// 게시글의 현재 글자수 및 최대 글자수 안내
// 게시글 좌측 하단 - 최대 글자수 안내
helpText2.innerText = `${maxWordLength}자 이내로 작성해주세요.`;
// 게시글 우측 하단 - 현재 글자수 / 최대 글자수
wordLength2.innerText = `${postContent2.value.length}/${maxWordLength}`;
// focus를 받자마자 0이 된 글자수 반영
postContent2.addEventListener("focus", (e) => {
    wordLength2.innerText = `${postContent2.value.length}/${maxWordLength}`;
});
// 입력되는 글자수를 실시간으로 반영
postContent2.addEventListener("keyup", (e) => {
    wordLength2.innerText = `${postContent2.value.length}/${maxWordLength}`;
});
// focus를 잃었을 때까지 입력된 글자수 반영
postContent2.addEventListener("blur", (e) => {
    wordLength2.innerText = `${postContent2.value.length}/${maxWordLength}`;
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

const thesisWrite2 = () => {
    let text = ``;

    text += ` <div class="container">
                    <form>
                        <div class="post-write-form-section">
                            <div class="form-section-header">
                                <p class="form-section-title subtitle-1">
                                    논문 공고 작성 <2>
                                </p>
                            </div>
                            <div class="form-input-section">
                                <div class="form-part">
                                    <label class="form-title font-body-1-bold"
                                        >프로젝트 예정 사항
                                        <span class="required">*</span>
                                    </label>
                                    <div class="mb8"></div>
                                    <div class="form-content">
                                        <div>
                                            <div class="content-textarea">
                                                <div class="textarea-border">
                                                    <textarea
                                                        class="moa-textarea font-body-2 text6"
                                                        name="textarea"
                                                        id="content-textarea1"
                                                        maxlength="5000"
                                                        rows="15"
                                                        style="
                                                            width: 100%;
                                                            min-width: 100%;
                                                            max-width: 100%;
                                                        "
                                                    >
<아래는 예시 양식입니다!!>

진행 분류 : 신규 프로젝트를 진행하려 합니다.
기획 상태 : 아이디어만 있는 상태
프로젝트 경험 : 양자물리학 프로젝트 진행 경험 있음
협업 예정 인력 : 지원자 본인 제외 교수 1명과 파트너 4명
                                                    </textarea>
                                                </div>
                                                <span
                                                    class="word-length word-length1"
                                                ></span>
                                                <span
                                                    class="help-text help-text1"
                                                ></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-part">
                                    <label class="form-title font-body-1-bold"
                                        >모집 요건
                                    </label>
                                    <div class="mb8"></div>
                                    <div class="form-content">
                                        <div>
                                            <div class="content-textarea">
                                                <div class="textarea-border">
                                                    <textarea
                                                        class="moa-textarea font-body-2 text6"
                                                        name="textarea"
                                                        id="title-textarea"
                                                        maxlength="260"
                                                        rows="4"
                                                        style="
                                                            width: 100%;
                                                            min-width: 100%;
                                                            max-width: 100%;
                                                            min-height: 30px;
                                                        "
                                                    >
모집 요건을 입력해 주세요. ex) 
주 3회 한국대학교 출근 후 협업 가능자, 관련 분야 전공자</textarea
                                                    >
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="divide-wrap"></div>
                                <div class="form-part">
                                    <label class="form-title font-body-1-bold"
                                        >프로젝트 내용
                                        <span class="required">*</span>
                                    </label>
                                    <div class="mb8"></div>
                                    <div class="form-content">
                                        <div>
                                            <div class="content-textarea">
                                                <div class="textarea-border">
                                                    <textarea
                                                        class="moa-textarea font-body-2 text6"
                                                        name="textarea"
                                                        id="content-textarea2"
                                                        maxlength="5000"
                                                        rows="15"
                                                        style="
                                                            width: 100%;
                                                            min-width: 100%;
                                                            max-width: 100%;
                                                        "
                                                    >
<아래는 예시 양식입니다!!>
                                                    
프로젝트 개요 : 최근 양자물리학과 관련하여 새롭게 등장한 OOO 이론에 관한 연구를 진행하려고 합니다.
현재 준비 상황 : 회의를 통해 연구에 필요한 기획을 완료하였고, 설비도 갖춘 상태입니다.
필요 요소 : 연구를 통해 OOO 이론을 뒷받침 할 근거가 될 수 있는 결과 도출
환경/진행방식 : 주 5일 / 9시 ~ 16시 / 한국대학교 연구실
요구 사항 : 일단 함꼐 연구를 진행하게되면 성실하게 참여해주셨으면 합니다.
산출물 :
    기획 : 세부 기획 사항은 첨부파일로 올려두었습니다.
    연구 결과 : 프로젝트 참여 인원들과 함께 한글파일로 작성 해주셔야 합니다.
참고 서비스/사이트 : https://www.thesisKorea.com/oootheory/14213
기타 참고 사항/유의 사항 : 연구 방해 및 연구 내용 유출 시 법적으로 대응할 예정입니다.
                                                    </textarea>
                                                </div>
                                                <span
                                                    class="word-length word-length2"
                                                ></span>
                                                <span
                                                    class="help-text help-text2"
                                                ></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="attach-wrap">
                                        <div class="attach-button-file-wrap">
                                            <div class="attach-button">
                                                <label>
                                                    <img
                                                        src="https://www.wishket.com/static/renewal/img/project/submit/btn_icon_add_s.svg"
                                                        alt="attach_img"
                                                    />
                                                    <div
                                                        class="font-body-2-medium text-moa"
                                                    >
                                                        파일첨부
                                                    </div>
                                                    <input
                                                        type="file"
                                                        class="attach-input"
                                                    />
                                                </label>
                                            </div>
                                        </div>
                                        <div class="attach-button-file-wrap">
                                            <div class="attach-button">
                                                <label>
                                                    <img
                                                        src="https://www.wishket.com/static/renewal/img/project/submit/btn_icon_add_s.svg"
                                                        alt="attach_img"
                                                    />
                                                    <div
                                                        class="font-body-2-medium text-moa"
                                                    >
                                                        파일첨부
                                                    </div>
                                                    <input
                                                        type="file"
                                                        class="attach-input"
                                                    />
                                                </label>
                                            </div>
                                        </div>
                                        <div class="attach-button-file-wrap">
                                            <div class="attach-button">
                                                <label>
                                                    <img
                                                        src="https://www.wishket.com/static/renewal/img/project/submit/btn_icon_add_s.svg"
                                                        alt="attach_img"
                                                    />
                                                    <div
                                                        class="font-body-2-medium text-moa"
                                                    >
                                                        파일첨부
                                                    </div>
                                                    <input
                                                        type="file"
                                                        class="attach-input"
                                                    />
                                                </label>
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

    writediv,innerHTML = text;

}


