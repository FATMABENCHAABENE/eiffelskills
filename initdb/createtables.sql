drop table if exists public.users;
create table
    public.users (
                    id bigint generated by default as identity not null,
                    name character varying not null,
                    surname character varying null,
                    mail character varying not null,
                    password text not null,
                    role text null,
                    constraint utilisateur_pkey primary key (id),
                    constraint user_role_check check (
                        (
                            role = any (
                                array['teacher'::text, 'student'::text, 'admin'::text]
                                )
                            )
                        )
);