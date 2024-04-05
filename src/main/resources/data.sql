-- inserting user
INSERT INTO user (user_id, email, password, username)
VALUES (1, 'Jack', '$2y$10$U9W.2XuqVecQwj/LF7zCbOdBZ4/ri398WSxcq97b9OU7AlXoEkyUK', 'username');

INSERT INTO user (user_id, email, password, username)
VALUES (2, 'Daniels', '$2y$10$U9W.2XuqVecQwj/LF7zCbOdBZ4/ri398WSxcq97b9OU7AlXoEkyUK', 'daniels');

-- inserting board of user
INSERT INTO board (board_id, board_name, user_id)
VALUES (1, 'Quarterly Planning', 1);

INSERT INTO board (board_id, board_name, user_id)
VALUES (2, 'Example Board2', 2);

-- inserting tasklist to board
INSERT INTO task_list (list_id, list_name, board_id)
VALUES (1, 'Research and Analysis', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (2, 'Home', 2);



-- inserting task to taskboard
INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (1,'Complete the report for the quarterly meeting' ,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed elit sed tortor lacinia lobortis. In non mi nec libero convallis convallis. Nullam at dolor dolor. Proin tincidunt semper ligula eget fringilla. Vestibulum varius ex varius, convallis mauris et, vestibulum justo. Morbi ut nisl eu risus varius pulvinar in quis felis. Nam mi justo, dapibus quis dignissim sed, blandit non felis. Fusce lobortis bibendum purus ut consequat. Ut vel imperdiet dui. Ut maximus libero sit amet ex cursus suscipit. Ut suscipit accumsan aliquet. Integer posuere fermentum risus sed maximus.', '2023-12-31', 'TODO', 1);

-- inserting comment to task
INSERT INTO comment (comment_id, content, created_at, user_id, task_id)
VALUES (1, 'orem ipsum dolor sit amet, consectetur adipiscing elit.', CURRENT_TIMESTAMP, 1, 1);

INSERT INTO comment (comment_id, content, created_at, user_id, task_id)
VALUES (2, 'orem ipsum dolor sit amet, consectetur adipiscing elit.', CURRENT_TIMESTAMP, 1, 1);

-- inserting attachment to task
INSERT INTO attachment (attachment_id , link, name, created_at, task_id)
VALUES (1, 'https://github.com/dominik24356', 'github profile  ', CURRENT_TIMESTAMP, 1);

INSERT INTO attachment (attachment_id, link, name, created_at, task_id)
VALUES (2, 'https://www.linkedin.com/in/dmxx', 'linkedin profile', CURRENT_TIMESTAMP, 1);

-- inserting label to task
INSERT INTO label (label_id, name, color, board_id)
VALUES (1, 'Important', 'RED', 1);

INSERT INTO label (label_id, name, color, board_id)
VALUES (2, 'Report', 'YELLOW', 1);

-- inserting task_label to task
INSERT INTO task_label (task_id, label_id)
VALUES (1, 1);

INSERT INTO task_label (task_id, label_id)
VALUES (1, 2);
