const listdiv = document.getElementById("listdiv");
const pagingdiv = document.getElementById("pagingdiv");

const showList = () => {
    let text = ``;

    // posts 데이터가 없을 때 처리 로직
    if (!posts || posts.length === 0) {
        text = `<div class="no-posts">게시글이 없습니다.</div>`;
    } else {
        posts.forEach((post) => {
            text += `<div class="ServiceTable_row_wrapper">-->
                                        <div class="ServiceTable_row">
                                            <div class="ServiceTable_cell">
                                                <input
                                                    type="checkbox"
                                                    class="userCheckbox"
                                                />
                                            </div>
                                            <div
                                                class="ServiceTable_cell post_ID"
                                            >
                                                <a href="/report/report?Id=${report.id}" class="report-id">
                                                 ${report.id || '번호 없음'}
                                            </div>
                                            <div
                                                class="ServiceTable_cell user_name"
                                            >
                                                ${report.memberNickName || '신고자 없음'} 
                                            </div>
                                            <div
                                                class="ServiceTable_cell Join_date"
                                            >
                                                ${report.createdDate || '날짜 정보 없음'} 
                                            </div>
                                            <div
                                                class="ServiceTable_cell post_title"
                                            >
                                                ${report.postTitle || '제목 없음'}
                                            </div>
                                            <div
                                                class="ServiceTable_cell hit_ctn"
                                            >
                                               ${report.replyCount || '조회수 없음'}
                                            </div>
                                            <div
                                                class="ServiceTable_cell reply_ctn"
                                            >
                                                56
                                            </div>
                                            <div
                                                class="ServiceTable_cell post_kind"
                                                
                                            >
                                                ${report.reportReason || '사유 없음'}
                                            </div>
                                            <div
                                                class="ServiceTable_cell editBtn"
                                            >
                                                <button class="report-status">
                                                ${report.reportStatus || '상태 없음'}</button>
                                            </div>
                                    </div>
            `;
        });
    }
    postCountElement.innerText = posts.length;
    listdiv.innerHTML = text;
};

const showPaging = () => {
    // console.log('showPaging 들어옴!');
    let text = ``;

    if (pagination.page && pagination.page > 1) {
        text += `
        <li class="page-item" id="page-prev-button">
            <a href="/report/list?page=${pagination.page - 1}" class="page-link">이전</a>
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
                    <a href="/report/list?page=${i}" class="page-link">${i}</a>
                </li>`;
            }
        }
    }

    if (pagination.page && pagination.page < pagination.pageCount) {
        text += `
        <li class="page-item" id="page-next-button">
            <a href="/report/list?page=${pagination.page + 1}" class="page-link">다음</a>
        </li>`;
    }

    console.log('Paging HTML:', text);

    pagingdiv.innerHTML = text;
};

showList();
showPaging();
console.log('Pagination Data:', pagination);
console.log('Posts Data:', posts);