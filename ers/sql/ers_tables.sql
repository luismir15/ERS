DROP TABLE ers_reimbursement;

CREATE TABLE ers_reimbursement
(
	reimb_id SERIAL NOT NULL CONSTRAINT ers_reimbursement_pk PRIMARY KEY
    , reimb_amount DOUBLE PRECISION NOT NULL
    , reimb_submitted TIMESTAMP NOT NULL
    , reimb_resolved TIMESTAMP
    , reimb_description VARCHAR(250)
    , reimb_author INT NOT NULL
    , reimb_resolver INT
    , reimb_status_id INT NOT NULL
    , reimb_type_id INT NOT NULL
);

alter table ers_reimbursement
	add constraint ers_reimbursement_status_fk
		foreign key (reimb_status_id) references ers_reimbursement_status;

alter table ers_reimbursement
	add constraint ers_reimbursement_type_fk
		foreign key (reimb_type_id) references ers_reimbursement_type;

alter table ers_reimbursement
	add constraint ers_user_fk_auth
		foreign key (reimb_author) references ers_users;

alter table ers_reimbursement
	add constraint ers_users_fk_reslvr
		foreign key (reimb_resolver) references ers_users;

alter table ers_users
	add constraint users_roles_fk
		foreign key (user_role_id) references ers_user_roles;

CREATE TABLE ers_reimbursement_type
(
    reimb_type_id SERIAL NOT NULL CONSTRAINT ers_reimbursement_type_pk PRIMARY KEY,
    reimb_type VARCHAR(20) NOT NULL
);

CREATE TABLE ers_reimbursement_status
(
    reimb_status_id SERIAL NOT NULL CONSTRAINT ers_reimbursement_status_pk PRIMARY KEY,
    reimb_status VARCHAR(20) NOT NULL
);

CREATE TABLE ers_users
(
    ers_user_id SERIAL NOT NULL CONSTRAINT ers_users_pk PRIMARY KEY,
    ers_username VARCHAR(50) NOT NULL,
    ers_password VARCHAR(50) NOT NULL,
    user_first_name VARCHAR(100) NOT NULL,
    user_last_time VARCHAR(100) NOT NULL,
    user_email VARCHAR(150) NOT NULL,
    user_role_id SERIAL NOT NULL CONSTRAINT users_roles_fk REFERENCES ers_user_roles
);

CREATE TABLE ers_user_roles
(
    ers_user_role_id SERIAL NOT NULL CONSTRAINT ers_user_roles_pk PRIMARY KEY,
    user_role VARCHAR(20) NOT NULL
);

