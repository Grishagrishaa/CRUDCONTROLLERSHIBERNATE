CREATE DATABASE university2
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'ru_RU.UTF-8'
    LC_CTYPE = 'ru_RU.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = 15;




CREATE SCHEMA IF NOT EXISTS belstu
    AUTHORIZATION postgres;




CREATE TABLE IF NOT EXISTS belstu."group"
(
    id bigint NOT NULL DEFAULT nextval('belstu.group_id_seq'::regclass),
    groupname character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT group_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS belstu."group"
    OWNER to postgres;





CREATE TABLE IF NOT EXISTS belstu.student
(
    id bigint NOT NULL DEFAULT nextval('belstu.student_id_seq'::regclass),
    age integer,
    name character varying(255) COLLATE pg_catalog."default",
    olympicgamer boolean,
    score double precision,
    CONSTRAINT student_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS belstu.student
    OWNER to postgres;





CREATE TABLE IF NOT EXISTS belstu.group_student
(
    group_id bigint NOT NULL,
    students_id bigint NOT NULL,
    CONSTRAINT uk_q86fxx5yf4p6hfwxl6wslfbcn UNIQUE (students_id),
    CONSTRAINT fk6mxor9kdmj27h35hyv0at0uh9 FOREIGN KEY (students_id)
        REFERENCES belstu.student (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkl4njpt1jirw63ixw8jw76ey92 FOREIGN KEY (group_id)
        REFERENCES belstu."group" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS belstu.group_student
    OWNER to postgres;