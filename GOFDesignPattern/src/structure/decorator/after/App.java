package structure.decorator.after;

public class App {

    private static boolean enableSpamFilter = true;
    private static boolean enableTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if(enableSpamFilter){
            commentService = new SpamFilteringDecorator(commentService);
        }
        if(enableTrimming){
            commentService = new TrimmingCommentDecorator(commentService);
        }
        Client client = new Client(commentService);
        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }
}
