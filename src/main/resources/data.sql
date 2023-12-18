-- inserting user
INSERT INTO user (user_id, login, password, username)
VALUES (1, 'login', 'password', 'username');

-- inserting board of user
INSERT INTO board (board_id, board_name, user_id)
VALUES (1, 'Example Board', 1);

-- inserting taskboard to board
INSERT INTO task_list (list_id, list_name, board_id)
VALUES (1, 'Example Task ListExample Task ListExample Task ListExample Task ListExample Task ListExample Task List', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (2, 'E', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (3, '', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (4, 'Example Task List', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (5, 'Example Task List', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (6, 'Example Task List', 1);

INSERT INTO task_list (list_id, list_name, board_id)
VALUES (7, 'Example Task List', 1);

-- inserting task to taskboard
INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (1, 'Example TaskExample TaskExample TaskExample Task', 'Task description Task descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionTask descriptionXD', '2023-12-31', 'Pending', 1);

INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (2, 'Example Task', 'Task description', '2023-12-31', 'Pending', 1);

INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (3, 'Example Task', 'Task description', '2023-12-31', 'Pending', 1);

INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (4, 'Example Task', 'Task description', '2023-12-31', 'Pending', 1);

INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (5, 'Example Task', 'Task description', '2023-12-31', 'Pending', 1);

INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (6, 'Example Task', 'Task description', '2023-12-31', 'Pending', 1);

INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (7, 'Example Task', 'Task description', '2023-12-31', 'Pending', 1);

INSERT INTO task (task_id, task_name, description, due_date, status, list_id)
VALUES (8, 'Example Task', 'Task description', '2023-12-31', 'Pending', 1);
