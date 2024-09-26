// "complete-button" 버튼에 클릭 이벤트 리스너 추가
document.getElementById("complete-button").addEventListener("click", (e) => {
    // 클릭 시 게시글 목록 페이지로 이동
    location.href = `/q&a_list.html/list?id=${qaPostDTO.id}`;
});
// "save-button" 버튼에 클릭 이벤트 리스너 추가
document.getElementById("save-button").addEventListener("click", (e) => {
    // 클릭 시 게시글 목록 페이지로 이동
    location.href = `/q&a_list.html/list?id=${qaPostDTO.id}`;
});