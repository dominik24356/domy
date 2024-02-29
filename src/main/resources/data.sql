-- inserting user
INSERT INTO user (user_id, email, password, username)
VALUES (1, 'Jack', '$2y$10$U9W.2XuqVecQwj/LF7zCbOdBZ4/ri398WSxcq97b9OU7AlXoEkyUK', 'username');

INSERT INTO user (user_id, email, password, username)
VALUES (2, 'Daniels', '$2y$10$U9W.2XuqVecQwj/LF7zCbOdBZ4/ri398WSxcq97b9OU7AlXoEkyUK', 'daniels');

-- inserting board of user
INSERT INTO board (board_id, board_name, user_id)
VALUES (1, 'Example Board1', 1);

INSERT INTO board (board_id, board_name, user_id)
VALUES (2, 'Example Board2', 2);

-- inserting tasklist to board
INSERT INTO task_list (list_id, list_name, board_id)
VALUES (1, 'Example Task ListExample', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (2, 'Example Task ListExample', 2);



-- inserting task to taskboard
INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (1, 'Example TaskExample TaskExample TaskExample Task', 'Task description Task descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionXD', '2023-12-31', 'TODO', 1);

-- inserting comment to task
INSERT INTO comment (comment_id, content, created_at, user_id, task_id)
VALUES (1, 'Comment 1 for Task 1', CURRENT_TIMESTAMP, 1, 1);

INSERT INTO comment (comment_id, content, created_at, user_id, task_id)
VALUES (2, 'Comment 2 for Task 1', CURRENT_TIMESTAMP, 1, 1);

-- inserting attachment to task
INSERT INTO attachment (attachment_id , link, name, created_at, task_id)
VALUES (1, 'https://www.google.com/webhp?hl=pl&sa=X&ved=0ahUKEwjHj72P2dGDAxUdVvEDHRubDMoQPAgJ', 'File 1', CURRENT_TIMESTAMP, 1);

INSERT INTO attachment (attachment_id, link, name, created_at, task_id)
VALUES (2, 'https://www.google.com/search?q=java&sca_esv=597084762&hl=pl&source=hp&ei=d_adZZCOK-eRxc8Pmb6QoAE&iflsig=ANes7DEAAAAAZZ4Eh7N2bSFgoZuEdyL7fMjg7UWGDKm2&udm=&ved=0ahUKEwjQpbCQ2dGDAxXnSPEDHRkfBBQQ4dUDCAo&uact=5&oq=java&gs_lp=Egdnd3Mtd2l6IgRqYXZhMgsQABiABBixAxiDATILEAAYgAQYsQMYgwEyCBAAGIAEGLEDMggQLhiABBixAzIIEC4YgAQYsQMyDhAuGIAEGMcBGK8BGJgFMgsQABiABBixAxiDATIIEAAYgAQYsQMyCxAAGIAEGLEDGIMBMgsQABiABBixAxiDAUjEJlCeBFjdJXAEeACQAQCYAakBoAGQBqoBAzAuNrgBA8gBAPgBAagCCsICChAAGAMYjwEY6gLCAgoQLhgDGI8BGOoCwgIREC4YgAQYsQMYgwEYxwEY0QPCAgUQABiABMICDhAuGIAEGMcBGK8BGI4FwgILEC4YgAQYsQMYgwHCAg4QLhiABBiKBRixAxiDAcICBRAuGIAEwgIOEC4YgAQYsQMYxwEY0QPCAg4QABiABBiKBRixAxiDAQ&sclient=gws-wiz', 'File 2', CURRENT_TIMESTAMP, 1);

-- inserting label to task
INSERT INTO label (label_id, name, color)
VALUES (1, 'Label 1', 'RED');

INSERT INTO label (label_id, name, color)
VALUES (2, 'Label 2', 'GREEN');

-- inserting task_label to task
INSERT INTO task_label (task_id, label_id)
VALUES (1, 1);

INSERT INTO task_label (task_id, label_id)
VALUES (1, 2);
