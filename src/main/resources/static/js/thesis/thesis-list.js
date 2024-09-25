// 더보기 참고
// let page = document.querySelector(".page-link.active").innerText;
// let text = ``;
// posts.forEach((post) => {
//     page++;
// });

const showList = () => {
    let text = ``;
    posts.forEach((post) => {
        text += `
        <div class="post-list">
            <div class="post-all">
                <div class="post-view-wrap">
                    <div class="post-view"></div>
                    <div class="post-view-count">
                        1
                    </div>
                </div>
                <div class="post-top">
                    <div class="post-title">
                        ${post.postTitle}
                    </div>
                    <div class="post-top-right">
                        <div
                            class="post-writer-school-major"
                        >
                            한국예술대학교 작곡과
                        </div>
                        <div
                            class="post-writer-name"
                        >
                            마에스트로장
                        </div>
                        <div
                            class="post-created-date"
                        >
                            2024/12/10
                        </div>
                    </div>
                </div>
                <div class="post-content">
                    한국대 작곡과 2학년 수업 자료
                    1년치 공유합니다. 같이 보면서
                    공부하실 분들은 여기로 와주세요
                    -> 오픈채팅방 링크
                </div>
            </div>
        </div>
        `;
    });

    listdiv.innerHTML = text;
}

const showPaging = () => {
    let text = ``;
    if(pagination.prev) {
        text += `
        <li
            class="page-item"
            id="page-prev-button"
        >
            <a href="/thesis/thesis-list?page=${pagination.startPage - 1}" class="page-link">이전</a>
        </li>
        `
    }
        for(let i=pagination.startPage; i<=pagination.endPage; i++){
            if(pagination.page === i){
                text += `
                <li class="page-item">
                    <a class="page-link active"
                        >${i}</a
                    >
                </li>
                `;
            }else{
                text += `
                <li class="page-item">
                    <a href="/thesis/thesis-list?page=${i}" class="page-link"
                        >${i}</a
                    >
                </li>
                `;
            }

        }
        if(pagination.next){
            text +=
            `
            <li
                class="page-item"
                id="page-next-button"
            >
                <a href="/thesis/thesis-list?page=${pagination.endPage + 1}" class="page-link">다음</a>
            </li>
            `;
        }
        pagingdiv.innerHTML = text;
}

showList();
showPaging();