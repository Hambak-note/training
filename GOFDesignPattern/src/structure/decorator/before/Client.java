package structure.decorator.before;

public class Client {

    private CommentService commentService;
    private boolean enabledSpamFiltering;
    private boolean enabledTrimming;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment){
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
//        Client client = new Client(new CommentService());
//        Client client = new Client(new TrimmingCommentService());
        Client client = new Client(new SpamFilteringCommentService());
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://xxx.xxx.xxx");
    }
}
