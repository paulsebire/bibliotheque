PGDMP     7                     x           bibliotheque    12.0    12.0 #    J           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            K           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            L           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            M           1262    74481    bibliotheque    DATABASE     �   CREATE DATABASE bibliotheque WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';
    DROP DATABASE bibliotheque;
                postgres    false            �            1259    85055    batch_job_execution    TABLE     �  CREATE TABLE public.batch_job_execution (
    job_execution_id bigint NOT NULL,
    version bigint,
    job_instance_id bigint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    status character varying(10),
    exit_code character varying(2500),
    exit_message character varying(2500),
    last_updated timestamp without time zone,
    job_configuration_location character varying(2500)
);
 '   DROP TABLE public.batch_job_execution;
       public         heap    postgres    false            �            1259    85102    batch_job_execution_context    TABLE     �   CREATE TABLE public.batch_job_execution_context (
    job_execution_id bigint NOT NULL,
    short_context character varying(2500) NOT NULL,
    serialized_context text
);
 /   DROP TABLE public.batch_job_execution_context;
       public         heap    postgres    false            �            1259    85068    batch_job_execution_params    TABLE     `  CREATE TABLE public.batch_job_execution_params (
    job_execution_id bigint NOT NULL,
    type_cd character varying(6) NOT NULL,
    key_name character varying(100) NOT NULL,
    string_val character varying(250),
    date_val timestamp without time zone,
    long_val bigint,
    double_val double precision,
    identifying character(1) NOT NULL
);
 .   DROP TABLE public.batch_job_execution_params;
       public         heap    postgres    false            �            1259    85117    batch_job_execution_seq    SEQUENCE     �   CREATE SEQUENCE public.batch_job_execution_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.batch_job_execution_seq;
       public          postgres    false            �            1259    85048    batch_job_instance    TABLE     �   CREATE TABLE public.batch_job_instance (
    job_instance_id bigint NOT NULL,
    version bigint,
    job_name character varying(100) NOT NULL,
    job_key character varying(32) NOT NULL
);
 &   DROP TABLE public.batch_job_instance;
       public         heap    postgres    false            �            1259    85119    batch_job_seq    SEQUENCE     v   CREATE SEQUENCE public.batch_job_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.batch_job_seq;
       public          postgres    false            �            1259    85076    batch_step_execution    TABLE     �  CREATE TABLE public.batch_step_execution (
    step_execution_id bigint NOT NULL,
    version bigint NOT NULL,
    step_name character varying(100) NOT NULL,
    job_execution_id bigint NOT NULL,
    start_time timestamp without time zone NOT NULL,
    end_time timestamp without time zone,
    status character varying(10),
    commit_count bigint,
    read_count bigint,
    filter_count bigint,
    write_count bigint,
    read_skip_count bigint,
    write_skip_count bigint,
    process_skip_count bigint,
    rollback_count bigint,
    exit_code character varying(2500),
    exit_message character varying(2500),
    last_updated timestamp without time zone
);
 (   DROP TABLE public.batch_step_execution;
       public         heap    postgres    false            �            1259    85089    batch_step_execution_context    TABLE     �   CREATE TABLE public.batch_step_execution_context (
    step_execution_id bigint NOT NULL,
    short_context character varying(2500) NOT NULL,
    serialized_context text
);
 0   DROP TABLE public.batch_step_execution_context;
       public         heap    postgres    false            �            1259    85115    batch_step_execution_seq    SEQUENCE     �   CREATE SEQUENCE public.batch_step_execution_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.batch_step_execution_seq;
       public          postgres    false            �            1259    88541    book    TABLE     �   CREATE TABLE public.book (
    id bigint NOT NULL,
    author character varying(255),
    cover_url character varying(255),
    name character varying(255)
);
    DROP TABLE public.book;
       public         heap    postgres    false            �            1259    88549    copy    TABLE     �   CREATE TABLE public.copy (
    id_copy bigint NOT NULL,
    dispo boolean NOT NULL,
    serial_number character varying(255),
    id bigint
);
    DROP TABLE public.copy;
       public         heap    postgres    false            �            1259    88554    email    TABLE     y   CREATE TABLE public.email (
    id bigint NOT NULL,
    contenu text,
    name character varying(255),
    objet text
);
    DROP TABLE public.email;
       public         heap    postgres    false            �            1259    88539    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    88562    reservation    TABLE       CREATE TABLE public.reservation (
    id_reservation bigint NOT NULL,
    cloturer boolean NOT NULL,
    date_emprunt timestamp without time zone,
    date_retour timestamp without time zone,
    id_utilisateur bigint,
    prolonger boolean NOT NULL,
    id_copy bigint
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �
           2606    85109 <   batch_job_execution_context batch_job_execution_context_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.batch_job_execution_context
    ADD CONSTRAINT batch_job_execution_context_pkey PRIMARY KEY (job_execution_id);
 f   ALTER TABLE ONLY public.batch_job_execution_context DROP CONSTRAINT batch_job_execution_context_pkey;
       public            postgres    false    207            �
           2606    85062 ,   batch_job_execution batch_job_execution_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.batch_job_execution
    ADD CONSTRAINT batch_job_execution_pkey PRIMARY KEY (job_execution_id);
 V   ALTER TABLE ONLY public.batch_job_execution DROP CONSTRAINT batch_job_execution_pkey;
       public            postgres    false    203            �
           2606    85052 *   batch_job_instance batch_job_instance_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.batch_job_instance
    ADD CONSTRAINT batch_job_instance_pkey PRIMARY KEY (job_instance_id);
 T   ALTER TABLE ONLY public.batch_job_instance DROP CONSTRAINT batch_job_instance_pkey;
       public            postgres    false    202            �
           2606    85096 >   batch_step_execution_context batch_step_execution_context_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.batch_step_execution_context
    ADD CONSTRAINT batch_step_execution_context_pkey PRIMARY KEY (step_execution_id);
 h   ALTER TABLE ONLY public.batch_step_execution_context DROP CONSTRAINT batch_step_execution_context_pkey;
       public            postgres    false    206            �
           2606    85083 .   batch_step_execution batch_step_execution_pkey 
   CONSTRAINT     {   ALTER TABLE ONLY public.batch_step_execution
    ADD CONSTRAINT batch_step_execution_pkey PRIMARY KEY (step_execution_id);
 X   ALTER TABLE ONLY public.batch_step_execution DROP CONSTRAINT batch_step_execution_pkey;
       public            postgres    false    205            �
           2606    88548    book book_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.book DROP CONSTRAINT book_pkey;
       public            postgres    false    212            �
           2606    88553    copy copy_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.copy
    ADD CONSTRAINT copy_pkey PRIMARY KEY (id_copy);
 8   ALTER TABLE ONLY public.copy DROP CONSTRAINT copy_pkey;
       public            postgres    false    213            �
           2606    88561    email email_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.email
    ADD CONSTRAINT email_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.email DROP CONSTRAINT email_pkey;
       public            postgres    false    214            �
           2606    85054    batch_job_instance job_inst_un 
   CONSTRAINT     f   ALTER TABLE ONLY public.batch_job_instance
    ADD CONSTRAINT job_inst_un UNIQUE (job_name, job_key);
 H   ALTER TABLE ONLY public.batch_job_instance DROP CONSTRAINT job_inst_un;
       public            postgres    false    202    202            �
           2606    88566    reservation reservation_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id_reservation);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    215            �
           2606    88567     copy fk6o2uvdbc58n9dxii3memq02ph    FK CONSTRAINT     y   ALTER TABLE ONLY public.copy
    ADD CONSTRAINT fk6o2uvdbc58n9dxii3memq02ph FOREIGN KEY (id) REFERENCES public.book(id);
 J   ALTER TABLE ONLY public.copy DROP CONSTRAINT fk6o2uvdbc58n9dxii3memq02ph;
       public          postgres    false    2748    213    212            �
           2606    88572 '   reservation fk8pb5tgtt4vt09t3uxx961hs3f    FK CONSTRAINT     �   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fk8pb5tgtt4vt09t3uxx961hs3f FOREIGN KEY (id_copy) REFERENCES public.copy(id_copy);
 Q   ALTER TABLE ONLY public.reservation DROP CONSTRAINT fk8pb5tgtt4vt09t3uxx961hs3f;
       public          postgres    false    215    2750    213            �
           2606    85110 +   batch_job_execution_context job_exec_ctx_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.batch_job_execution_context
    ADD CONSTRAINT job_exec_ctx_fk FOREIGN KEY (job_execution_id) REFERENCES public.batch_job_execution(job_execution_id);
 U   ALTER TABLE ONLY public.batch_job_execution_context DROP CONSTRAINT job_exec_ctx_fk;
       public          postgres    false    2740    203    207            �
           2606    85071 -   batch_job_execution_params job_exec_params_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.batch_job_execution_params
    ADD CONSTRAINT job_exec_params_fk FOREIGN KEY (job_execution_id) REFERENCES public.batch_job_execution(job_execution_id);
 W   ALTER TABLE ONLY public.batch_job_execution_params DROP CONSTRAINT job_exec_params_fk;
       public          postgres    false    2740    204    203            �
           2606    85084 %   batch_step_execution job_exec_step_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.batch_step_execution
    ADD CONSTRAINT job_exec_step_fk FOREIGN KEY (job_execution_id) REFERENCES public.batch_job_execution(job_execution_id);
 O   ALTER TABLE ONLY public.batch_step_execution DROP CONSTRAINT job_exec_step_fk;
       public          postgres    false    2740    203    205            �
           2606    85063 $   batch_job_execution job_inst_exec_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.batch_job_execution
    ADD CONSTRAINT job_inst_exec_fk FOREIGN KEY (job_instance_id) REFERENCES public.batch_job_instance(job_instance_id);
 N   ALTER TABLE ONLY public.batch_job_execution DROP CONSTRAINT job_inst_exec_fk;
       public          postgres    false    203    2736    202            �
           2606    85097 -   batch_step_execution_context step_exec_ctx_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.batch_step_execution_context
    ADD CONSTRAINT step_exec_ctx_fk FOREIGN KEY (step_execution_id) REFERENCES public.batch_step_execution(step_execution_id);
 W   ALTER TABLE ONLY public.batch_step_execution_context DROP CONSTRAINT step_exec_ctx_fk;
       public          postgres    false    206    2742    205           