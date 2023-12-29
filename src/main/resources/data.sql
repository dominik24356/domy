-- inserting user
INSERT INTO user (user_id, login, password, username)
VALUES (1, 'login', 'password', 'username');

-- inserting board of user
INSERT INTO board (board_id, board_name, user_id)
VALUES (1, 'Example Board', 1);

-- inserting taskboard to board
INSERT INTO task_list (list_id, list_name, board_id)
VALUES (1, 'Example Task ListExample', 1);



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
VALUES (1, 'file1.txt', 'File 1', CURRENT_TIMESTAMP, 1);

INSERT INTO attachment (attachment_id, link, name, created_at, task_id)
VALUES (2, 'file2.txt', 'File 2', CURRENT_TIMESTAMP, 1);

-- inserting label to task
INSERT INTO label (label_id, name, color, task_id)
VALUES (1, 'Label 1', 'RED', 1);

INSERT INTO label (label_id, name, color, task_id)
VALUES (2, 'Label 2', 'GREEN', 1);
