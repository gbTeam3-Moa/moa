const listdiv = document.getElementById("listdiv");
const pagingdiv = document.getElementById("pagingdiv");

const showList = () => {
    let text = ``;

    // reports 데이터가 없을 때 처리 로직
    if (!reports || reports.length === 0) {
        text = `<div class="no-reports">게시글이 없습니다.</div>`;
    } else {
        reports.forEach((report) => {
            text += `<div class="ServiceTable_row_wrapper">
                                        <div class="ServiceTable_row">
                                            <div class="ServiceTable_cell">
                                                <input
                                                    type="checkbox"
                                                    class="userCheckbox"
                                                />
                                            </div>
                                            <div
                                                class="ServiceTable_cell post_ID"
                                                id="report-num"
                                            >
                                                <a href="/report/report?Id=${report.id}" class="report-id">
                                                 ${report.id || '번호 없음'}
                                            </div>
                                            <div
                                                class="ServiceTable_cell user_name"
                                                id="reporter"
                                            >
                                                ${report.memberNickName || '신고자 없음'} 
                                            </div>
                                            <div
                                                class="ServiceTable_cell Join_date"
                                                id="create-date"
                                            >
                                                ${report.createdDate || '날짜 정보 없음'} 
                                            </div>
                                            <div
                                                class="ServiceTable_cell post_title"
                                                id="post-title"  
                                            >
                                                ${report.postTitle || '제목 없음'}
                                            </div>
                                            <div
                                                class="ServiceTable_cell hit_ctn"
                                                id="post-view"
                                             >
                                                ${report.postView || '조회수 없음'}
                                             </div>
                                             <div
                                                class="ServiceTable_cell hit_ctn"
                                                id="count-reply"
                                             >
                                                ${report.replyCount || '댓글 없음'}
                                             </div>
                                            <div
                                                class="ServiceTable_cell post_kind"
                                                id="report-reason"
                                            >
                                                ${report.reportReason || '사유 없음'}
                                            </div>
                                            <div
                                                class="ServiceTable_cell editBtn"
                                                id="report-status"
                                            >
                                                <button class="report-status"
                                                id="report-status">
                                                ${report.reportStatus || '상태 없음'}
                                                <a href="/report/report-inquiry"></a> 
                                                </button>
                                            </div>
                                    </div>
            `;
        });
    }
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
console.log('reports Data:', reports);