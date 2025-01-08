drop table if exists public.user;
create table
    public.user (
                    id bigint generated by default as identity not null,
                    name character varying not null,
                    surname character varying null,
                    birth date null,
                    contact character varying null,
                    password text not null,
                    constraint utilisateur_pkey primary key (id)
);