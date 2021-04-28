/*
    test cases
*/
--creating users (insert into role table first)
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_time, user_email, user_role_id) VALUES ('luismir15', 'password', 'Luis', 'Miranda', 'luis@email.com', 1);
INSERT INTO ers_user_roles(user_role) VALUES ('employee');

INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_time, user_email, user_role_id)
    VALUES ('carlosher15', 'password', 'Carlos', 'Hernandez', 'carlos@email.com', 2);
INSERT INTO ers_user_roles(user_role) VALUES ('employee');

INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_time, user_email, user_role_id)
    VALUES ('javiernav20', 'password', 'Javier', 'Navarro', 'javier@company.com', 3);
INSERT INTO ers_user_roles(user_role) VALUES ('manager');

SELECT * FROM ers_users;
SELECT * FROM ers_user_roles;
--------------------------------------------------------------------------------

--creating an reimbursement
--for luis
INSERT INTO ers_reimbursement_status(reimb_status) VALUES ('in progess');
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('employee');
SELECT * FROM ers_reimbursement_status;
SELECT * FROM ers_reimbursement_type;
INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)
    VALUES (14, current_timestamp, 'test reimb', 4, 1, 1);
SELECT * FROM ers_reimbursement;

--------------------------------------------------------------------------------
/*
    scenario as of now:
    luis just created an account and submitted a reimbursement request.
    later javier(the manager) takes a look and gives the okay for the request.
    for managers to do some work they will be UPDATING table. no insertions.
 */
--hi im javier and imma do some request processing :p. UPDATE(ers_reimbursement,status)
UPDATE ers_reimbursement_status
    SET reimb_status = 'resolved'
        WHERE reimb_status_id = 1;
UPDATE ers_reimbursement
    SET  reimb_resolved = current_timestamp, reimb_resolver = 6
        WHERE reimb_id = 5;

--lets try to make it better
UPDATE ers_reimbursement_status
    SET reimb_status = 'resolved'
        FROM ers_reimbursement
            WHERE ers_reimbursement_status.reimb_status_id = 4 AND ers_reimbursement_status.reimb_status_id = ers_reimbursement.reimb_status_id;


------cleanup
DELETE FROM ers_reimbursement_status WHERE reimb_status_id = 3;
DELETE FROM ers_reimbursement_type WHERE reimb_type_id = 3;