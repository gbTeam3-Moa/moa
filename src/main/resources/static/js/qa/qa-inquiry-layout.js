// 작성하기 버튼 가져오기
const formSubmit = document.querySelector(".comment-complete-button");
const replyList = document.getElementById("replyList");
// 버튼 클릭시 이벤트 (추후수정)
formSubmit.addEventListener("click", () => {
    alert("작성이 완료되었습니다");
})

const showList = (replies) => {
    let text = ``; // 초기화

    replies.forEach((reply) => {
        text += `
            <div class="comment-writer">
                <img src="https://cdn.wishket.com/profiles/2828_20191121_db85568715d9aacd.jpg" alt="" class="comment-writer-image" />
                <a href="https://www.wishket.com/partners/p/Wishket/" class="comment-writer-username">${reply.memberNickName}</a>
            </div>
            <p class="comment">
                ${reply.replyContent}
            </p>
            <div class="comment-created-date">
                ${reply.createdDate}
            </div>
        `;
    });

    // 최종적으로 생성된 HTML을 원하는 div에 삽입
    replyList.innerHTML = text; // div의 ID를 replyList로 가정
}

// 예시 호출
showList(replies);

// 댓글 갯수
const postId = "postId"/* 게시물 ID를 여기에 넣으세요 */;

// 댓글 개수 가져오기
fetch(`/replies/${postId}/1`)  // 페이지 번호는 1로 설정
    .then(response => response.json())
    .then(data => {
        const commentCount = data.pagination.total; // total이 댓글 수입니다.
        document.querySelector('.comment-count').textContent = commentCount;
    })
    .catch(error => console.error('Error fetching comment count:', error));