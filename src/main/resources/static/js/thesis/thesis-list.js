// 더보기 참고
// let page = document.querySelector(".page-link.active").innerText;
// let text = ``;
// posts.forEach((post) => {
//     page++;
// });
const listdiv = document.getElementById("listdiv");
const pagingdiv = document.getElementById("pagingdiv");
const postCountElement = document.querySelector(".post-count");

const showList = () => {
    let text = ``;

    // posts 데이터가 없을 때 처리 로직
    if (!posts || posts.length === 0) {
        text = `<div class="no-posts">게시글이 없습니다.</div>`;
    } else {
        posts.forEach((post) => {
            text += `
            <div class="post-list">
                <div class="post-all">
                    <div class="post-view-wrap">
                        <div class="post-view"></div>
                        <div class="post-view-count">
                            ${post.postView || 0} 
                        </div>
                    </div>
                    <div class="post-top">
                        <div class="post-title-wrap">
                            <a href="/list-inquiry?id=${post.id}" class="post-title">
                                ${post.postTitle || '제목 없음'}
                            </a>
                        </div>
                        <div class="post-top-right">
                            <div class="post-writer-school-major">
                                ${post.professorMajor || '학과 정보 없음'} 
                            </div>
                            <div class="post-writer-name">
                                ${post.memberNickName}
                            </div>
                            <div class="post-created-date">
                                ${post.updatedDate || '날짜 정보 없음'} 
                            </div>
                        </div>
                    </div>
                    <div class="post-content">
                        ${post.postContent || '내용 없음'}
                    </div>
                </div>
            </div>
            `;
        });
    }
    postCountElement.innerText = posts.length;
    listdiv.innerHTML = text;
};


const showPaging = () => {
    console.log('showPaging 호출됨');
    let text = ``;

    if (pagination.page && pagination.page > 1) {
        text += `
        <li class="page-item" id="page-prev-button">
            <a href="/thesis/thesis-list?page=${pagination.page - 1}" class="page-link">이전</a>
        </li>`;
    }

    if (pagination.pageCount && pagination.pageCount > 0) {
        for (let i = 1; i <= pagination.pageCount; i++) {
            if (pagination.page === i) {
                text += `
                <li class="page-item">
                    <a class="page-link active">${i}</a>
                </li>`;
            } else {
                text += `
                <li class="page-item">
                    <a href="/thesis/thesis-list?page=${i}" class="page-link">${i}</a>
                </li>`;
            }
        }
    }

    if (pagination.page && pagination.page < pagination.pageCount) {
        text += `
        <li class="page-item" id="page-next-button">
            <a href="/thesis/thesis-list?page=${pagination.page + 1}" class="page-link">다음</a>
        </li>`;
    }

    console.log('Paging HTML:', text);

    pagingdiv.innerHTML = text;
};

showList();
showPaging();
console.log('Pagination Data:', pagination);
console.log('Posts Data:', posts); 