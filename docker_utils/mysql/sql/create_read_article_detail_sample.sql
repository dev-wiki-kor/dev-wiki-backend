-- Connect to the MySQL server (update with your connection details)
--mysql -u devwiki -pdevwiki -D dev_wiki <<MYSQL_SCRIPT

-- Drop tables if they exist
DROP TABLE IF EXISTS article_metadata;
DROP TABLE IF EXISTS article_reaction;
DROP TABLE IF EXISTS article_version_content;

-- Create table article_metadata
  create table article_metadata (
        deleted bit ,
        article_metadata_id bigint not null,
        created_at datetime(6),
        updated_at datetime(6),
        uploader_id bigint,
        source_url varchar(255),
        tags varchar(255),
        title varchar(255),
        primary key (article_metadata_id)
    );

-- Create table article_reaction
 create table article_reaction (
        deleted bit ,
        account_id bigint,
        article_id bigint,
        article_reaction_id bigint not null,
        created_at datetime(6),
        updated_at datetime(6),
        reaction enum ('DISLIKE','LIKE'),
        primary key (article_reaction_id)
    ) ;

-- Create table article_version_content
create table article_version_content (
        deleted bit ,
        article_id bigint,
        article_version_content_id bigint not null,
        created_at datetime(6),
        editor_id bigint,
        updated_at datetime(6),
        version bigint,
        content varchar(255),
        primary key (article_version_content_id)
    ) ;

-- Insert sample data for ArticleMetadata
INSERT INTO article_metadata (created_at, article_metadata_id, uploader_id, source_url, title, tags,deleted ) VALUES
('2023-10-22 12:00:00', 1, 1001, 'http://example.com/1', 'Title 1', '313233',0);

INSERT INTO article_metadata (created_at, article_metadata_id, uploader_id, source_url, title, tags,deleted ) VALUES
('2023-10-22 13:00:00', 2, 1002, 'http://example.com/2', 'Title 2', '343536',0);

-- Insert sample data for ArticleVersionContent
INSERT INTO article_version_content (article_id, created_at, editor_id, article_version_content_id, version, content,deleted ) VALUES
(1, '2023-10-22 12:15:00', 1001, 1, 1, 'Content 1.1',0);
INSERT INTO article_version_content (article_id, created_at, editor_id, article_version_content_id, version, content,deleted ) VALUES
(1, '2023-10-22 12:30:00', 1001, 2, 2, 'Content 1.2',0);
INSERT INTO article_version_content (article_id, created_at, editor_id, article_version_content_id, version, content,deleted ) VALUES
(1, '2023-10-22 12:45:00', 1002, 3, 3, 'Content 1.3',0);

INSERT INTO article_version_content (article_id, created_at, editor_id, article_version_content_id, version, content,deleted ) VALUES
(2, '2023-10-22 13:15:00', 1002, 4, 1, 'Content 2.1',0);
INSERT INTO article_version_content (article_id, created_at, editor_id, article_version_content_id, version, content,deleted ) VALUES
(2, '2023-10-22 13:30:00', 1001, 5, 2, 'Content 2.2',0);
INSERT INTO article_version_content (article_id, created_at, editor_id, article_version_content_id, version, content,deleted ) VALUES
(2, '2023-10-22 13:45:00', 1002, 6, 3, 'Content 2.3',0);

-- Insert sample data for ArticleReaction
INSERT INTO article_reaction (account_id, article_id, article_reaction_id, reaction,deleted) VALUES
(1001, 1, 1, 'LIKE',0);
INSERT INTO article_reaction (account_id, article_id, article_reaction_id, reaction,deleted) VALUES
(1002, 1, 2, 'DISLIKE',0);
INSERT INTO article_reaction (account_id, article_id, article_reaction_id, reaction,deleted) VALUES
(1003, 2, 3, 'LIKE',0);
INSERT INTO article_reaction (account_id, article_id, article_reaction_id, reaction,deleted) VALUES
(1004, 2, 4, 'LIKE',0);
INSERT INTO article_reaction (account_id, article_id, article_reaction_id, reaction,deleted) VALUES
(1005, 1, 5, 'DISLIKE',0);

-- End of SQL script
MYSQL_SCRIPT
