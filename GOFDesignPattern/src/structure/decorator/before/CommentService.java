package structure.decorator.before;

public class CommentService {

    /**
     * 메시지를 출력만 했었는데
     * trim을 하고 싶은걸....
     * CommentService 를 확장해서 TrimmingCommentService 를 만들자
     */
    public void addComment(String comment){
        System.out.println(comment);
    }
}
