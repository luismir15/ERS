--well lets see how this goes :}

-- ers_reimbursements JOIN with status type & ... user?!
-- from that table i don't want no ids... give me that string!!!
--user: view who resolved the reimbursement
SELECT reimb_id AS id, reimb_amount AS amount , reimb_submitted AS submited, reimb_resolved AS resolved,
       reimb_description AS descriptio, eua.ers_username AS author, eur.ers_username AS resolver, ers.reimb_status_id AS statusid, reimb_status AS status,
       reimb_type AS type FROM ers_reimbursement r
           JOIN ers_users eua ON r.reimb_author = eua.ers_user_id
           LEFT JOIN ers_users eur ON r.reimb_resolver = eur.ers_user_id
           JOIN ers_reimbursement_status ers ON ers.reimb_status_id = r.reimb_status_id
           JOIN ers_reimbursement_type ert ON ert.reimb_type_id = r.reimb_type_id
        WHERE eua.ers_username = 'luismir15';

DROP VIEW reimb_join_full;

CREATE VIEW reimb_join_full AS
    SELECT reimb_id AS id, reimb_amount AS amount , reimb_submitted AS submited, reimb_resolved AS resolved,
           reimb_description AS descriptio, eua.ers_username AS author, eur.ers_username AS resolver,
           ers.reimb_status_id AS statusid, reimb_status AS status, reimb_type AS type FROM ers_reimbursement r
               JOIN ers_users eua ON r.reimb_author = eua.ers_user_id
               LEFT JOIN ers_users eur ON r.reimb_resolver = eur.ers_user_id
               JOIN ers_reimbursement_status ers ON ers.reimb_status_id = r.reimb_status_id
               JOIN ers_reimbursement_type ert ON ert.reimb_type_id = r.reimb_type_id;

SELECT * FROM  reimb_join_full;

------------------------------------------------------------------------------------------------------------------------
DROP VIEW reimb_join_user;

CREATE VIEW reimb_join_user AS
    SELECT reimb_id AS id, reimb_amount AS amount , reimb_submitted AS submited, reimb_resolved AS resolved, reimb_description AS descriptio,
           ers_username AS resolver, reimb_status AS status, reimb_type AS type FROM ers_reimbursement
                 INNER JOIN ers_reimbursement_type et ON ers_reimbursement.reimb_type_id = et.reimb_type_id
                 INNER JOIN ers_reimbursement_status ers ON ers.reimb_status_id = ers_reimbursement.reimb_status_id
                 INNER JOIN ers_users eu on ers_reimbursement.reimb_resolver = eu.ers_user_id;

select * from reimb_join_user;

------------------------------------------------------------------------------------------------------------------------

--manager: view who did the reimbursement
SELECT reimb_id AS id, reimb_amount AS amount , reimb_submitted AS submited, reimb_resolved AS resolved, reimb_description AS descriptio,
       ers_username AS author, reimb_status AS status, reimb_type AS type FROM ers_reimbursement
             INNER JOIN ers_reimbursement_type et ON ers_reimbursement.reimb_type_id = et.reimb_type_id
             INNER JOIN ers_reimbursement_status ers ON ers.reimb_status_id = ers_reimbursement.reimb_status_id
             INNER JOIN ers_users eu on ers_reimbursement.reimb_author = eu.ers_user_id;

DROP VIEW reimb_join_user;

CREATE VIEW reimb_join_manager AS
    SELECT reimb_id AS id, reimb_amount AS amount , reimb_submitted AS submited, reimb_resolved AS resolved, reimb_description AS descriptio,
           ers_username AS author, reimb_status AS status, reimb_type AS type FROM ers_reimbursement
               INNER JOIN ers_reimbursement_type et ON ers_reimbursement.reimb_type_id = et.reimb_type_id
               INNER JOIN ers_reimbursement_status ers ON ers.reimb_status_id = ers_reimbursement.reimb_status_id
               INNER JOIN ers_users eu on ers_reimbursement.reimb_author = eu.ers_user_id;

SELECT * FROM reimb_join_manager WHERE author = 'luismir15';

------------------------------------------------------------------------------------------------------------------------

--user info
SELECT ers_user_id AS id, ers_username AS username, ers_password AS password, user_first_name AS firstname, user_last_time AS lastname,
        user_email AS email, user_role AS role FROM ers_users
            INNER JOIN ers_user_roles eur ON eur.ers_user_role_id = ers_users.user_role_id;

DROP VIEW user_join;

CREATE VIEW user_join AS
    SELECT ers_user_id AS id, ers_username AS username, ers_password AS password, user_first_name AS firstname, user_last_time AS lastname,
           user_email AS email, user_role AS role FROM ers_users
                INNER JOIN ers_user_roles eur ON eur.ers_user_role_id = ers_users.user_role_id;

SELECT * FROM user_join WHERE username = 'luismir15';
