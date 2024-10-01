const replyService = (() => {
    // 댓글 작성 메소드
    const write = async (reply) => {
        // POST 요청으로 댓글을 작성
        await fetch("/replies/write", {
            method: "post", // HTTP 메소드: POST
            body: JSON.stringify(reply) // 댓글 데이터를 JSON 형태로 변환하여 요청 본문에 담기
        });
    }

    // 댓글 목록 조회 메소드
    const getList = async (page, postId, callback) => {
        // 특정 게시물 ID와 페이지 번호에 따른 댓글 목록을 GET 요청으로 조회
        const response = await fetch(`/replies/${postId}/${page}`);
        const replies = await response.json(); // 응답을 JSON으로 파싱

        // 콜백 함수가 주어졌다면 호출하여 댓글 목록 전달
        if(callback){
            callback(replies);
        }
    }

    // 댓글 수정 메소드
    const update = async (reply) => {
        // PUT 요청으로 댓글을 수정
        await fetch("/replies/update", {
            method: "put", // HTTP 메소드: PUT
            body: JSON.stringify(reply) // 수정할 댓글 데이터를 JSON 형태로 변환하여 요청 본문에 담기
        });
    }

    // 댓글 삭제 메소드
    const remove = async (id) => {
        // DELETE 요청으로 특정 ID의 댓글 삭제
        await fetch(`/replies/${id}`, {
            method: "delete" // HTTP 메소드: DELETE
        });
    }

    // 공개할 메소드들을 반환
    return {write: write, getList: getList, update: update, remove: remove};
})();
