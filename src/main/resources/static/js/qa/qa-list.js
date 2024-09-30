// "post-write-button" 버튼에 클릭 이벤트 리스너 추가
const click = document.getElementById("post-write-button").addEventListener("click", (e) => {
    // 클릭 시 게시글 작성 페이지로 이동
    location.href = `/qa/qa-write`;
});

// 게시글 목록을 표시하는 함수
const listdiv = document.getElementById('listdiv');
const pagingUl = document.getElementById('pagingUl');
const isnew = document.getElementById('newMark');
const showList = () => {
    let text = ``; // HTML 내용을 저장할 변수 초기화
    const currentTime = new Date(); // 현재 시간
    posts.forEach((post) => {
        const postCreatedTime = new Date(post.updatedDate); // 게시물 생성 시간
        const timeDifference = currentTime - postCreatedTime; // 시간 차이 (ms)

        // 24시간 이내에 작성된 게시물인지 확인
        const isNew = timeDifference < 86400000 ; // 86400000ms = 24시간, 3600000ms = 1시간(test용)
        text += `
        <div class="post-list">
            <div class="post-all">
                <div class="post-view-wrap">
                    <div class="post-view"></div>
                    <div class="post-view-count">
                        ${post.postView} <!-- 게시글 조회수 -->
                    </div>
                </div>
                <div class="post-top">
                   <div class="post-title">
                    <a class="go-qa-inquiry" href="/qa/qa-inquiry">
                        <div class="post-title">
                        <div
                            class="QA-font-style"
                            >
                             Q.
                           </div>
                           <div
                          class="QA-title-font"
                           >
                           ${post.postTitle} <!-- 게시글 제목 -->
                            </div>
                            </div>
                            </a>
                            ${isNew ? `<div class="status-mark new-mark">NEW</div>` : ''}  
                    </div>
                    <div class="post-top-right">
                        <div class="post-writer-school-major">
                            ${post.memberMajor} <!-- 작성자 학과 -->
                        </div>
                        <div class="post-writer-name">
                            ${post.memberNickname} <!-- 작성자 이름 -->
                        </div>
                        <div class="post-created-date">
                            ${post.updatedDate} <!-- 게시글 작성 날짜 -->
                        </div>
                    </div>
                </div>
                <div class="post-content">
                <div class="QA-font-style">
                    A.
                </div>
                   <div class="QA-title-font">
                       ${post.postContent}<!-- 게시글 내용 -->
                   </div>
                </div>
            </div>
        </div>
        `;
    });

    listdiv.innerHTML = text;
}

// 페이지 네비게이션을 표시하는 함수
const showPaging = () => {
    let text = ``; // HTML 내용을 저장할 변수 초기화
    if (pagination.prev) {
        text += `
        <li class="page-item" id="page-prev-button">
            <a href="/qa/qa-list?page=${pagination.startPage - 1}" class="page-link">이전</a>
        </li>
        `;
    }
    // 페이지 번호 생성
    for (let i = pagination.startPage; i <= pagination.endPage; i++) {
        if (pagination.page === i) {
            // 현재 페이지인 경우
            text += `
                <li class="page-item">
                    <a class="page-link active">${i}</a>
                </li>
            `;
        } else {
            // 다른 페이지인 경우
            text += `
                <li class="page-item">
                    <a href="/qa/qa-list?page=${i}" class="page-link">${i}</a>
                </li>
            `;
        }
    }
    if (pagination.next) {
        text += `
        <li class="page-item" id="page-next-button">
            <a href="/qa/qa-list?page=${pagination.endPage + 1}" class="page-link">다음</a>
        </li>
        `;
    }
    // 페이지 네비게이션을 HTML 요소에 삽입
    console.log(text);
    console.log(pagination.startPage);
    console.log(pagination.endPage);
    pagingUl.innerHTML = text;
}

// 게시글 목록과 페이지 네비게이션 표시 함수 호출
showList();
showPaging();
document.getElementById("totalSpan").innerHTML = pagination.total;

if(pagination.ordType == 1){
    document.getElementsByClassName("arrange-type")[1].classList.remove("selected")
    document.getElementsByClassName("arrange-type")[0].classList.add("selected")
}else if (pagination.ordType == 2){
    document.getElementsByClassName("arrange-type")[0].classList.remove("selected")
    document.getElementsByClassName("arrange-type")[1].classList.add("selected")
}

