-- Connect to the MySQL server (update with your connection details)
mysql -u devwiki -pdevwiki -D dev_wiki <<MYSQL_SCRIPT

-- Drop tables if they exist
DROP TABLE IF EXISTS article_metadata;
DROP TABLE IF EXISTS article_reaction;
DROP TABLE IF EXISTS article_version_content;

-- Create table article_metadata
CREATE TABLE article_metadata (
    created_at DATETIME(6),
    id BIGINT NOT NULL,
    uploader_id BIGINT,
    source_url VARCHAR(255),
    title VARCHAR(255),
    tags VARBINARY(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Create table article_reaction
CREATE TABLE article_reaction (
    account_id BIGINT,
    article_id BIGINT,
    id BIGINT NOT NULL,
    reaction ENUM ('DISLIKE', 'LIKE'),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Create table article_version_content
CREATE TABLE article_version_content (
    article_id BIGINT,
    edited_at DATETIME(6),
    editor_id BIGINT,
    id BIGINT NOT NULL,
    version BIGINT,
    content VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Insert sample data for ArticleMetadata
INSERT INTO article_metadata (created_at, id, uploader_id, source_url, title, tags) VALUES
('2023-10-22 12:00:00', 1, 1001, 'http://example.com/1', 'Title 1', '313233');

INSERT INTO article_metadata (created_at, id, uploader_id, source_url, title, tags) VALUES
('2023-10-22 13:00:00', 2, 1002, 'http://example.com/2', 'Title 2', '343536');

-- Insert sample data for ArticleVersionContent
INSERT INTO article_version_content (article_id, edited_at, editor_id, id, version, content) VALUES
(1, '2023-10-22 12:15:00', 1001, 1, 1, 'Content 1.1');
INSERT INTO article_version_content (article_id, edited_at, editor_id, id, version, content) VALUES
(1, '2023-10-22 12:30:00', 1001, 2, 2, 'Content 1.2');
INSERT INTO article_version_content (article_id, edited_at, editor_id, id, version, content) VALUES
(1, '2023-10-22 12:45:00', 1002, 3, 3, 'Content 1.3');

INSERT INTO article_version_content (article_id, edited_at, editor_id, id, version, content) VALUES
(2, '2023-10-22 13:15:00', 1002, 4, 1, 'Content 2.1');
INSERT INTO article_version_content (article_id, edited_at, editor_id, id, version, content) VALUES
(2, '2023-10-22 13:30:00', 1001, 5, 2, 'Content 2.2');
INSERT INTO article_version_content (article_id, edited_at, editor_id, id, version, content) VALUES
(2, '2023-10-22 13:45:00', 1002, 6, 3, 'Content 2.3');

-- Insert sample data for ArticleReaction
INSERT INTO article_reaction (account_id, article_id, id, reaction) VALUES
(1001, 1, 1, 'LIKE');
INSERT INTO article_reaction (account_id, article_id, id, reaction) VALUES
(1002, 1, 2, 'DISLIKE');
INSERT INTO article_reaction (account_id, article_id, id, reaction) VALUES
(1003, 2, 3, 'LIKE');
INSERT INTO article_reaction (account_id, article_id, id, reaction) VALUES
(1004, 2, 4, 'LIKE');
INSERT INTO article_reaction (account_id, article_id, id, reaction) VALUES
(1005, 1, 5, 'DISLIKE');

-- End of SQL script
MYSQL_SCRIPT
