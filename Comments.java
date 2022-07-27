package com.Group13.BookstoreProject;
import java.util.ArrayList;
import java.util.List;


public class Comments {
    private List<Comment> commentList;

    // Method to return the list of comments
    public List<Comment> getCommentList()
    {
        if (commentList == null) {
            commentList = new ArrayList<>();
        }
        return commentList;
    }

    public void setCommentList(List<Comment> commentList)
    {
        this.commentList = commentList;
    }
}
