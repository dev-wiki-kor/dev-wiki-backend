-- Insert example data for the article_metadata table
INSERT INTO article_metadata (deleted, created_at, updated_at, uploader_id, source_url, title)
VALUES
    (0, NOW(), NOW(), 1, 'http://example.com/1', 'Sample Article 1'),
    (0, NOW(), NOW(), 2, 'http://example.com/2', 'Sample Article 2'),
    (0, NOW(), NOW(), 3, 'http://example.com/3', 'Sample Article 3'),
    (0, NOW(), NOW(), 4, 'http://example.com/4', 'Sample Article 4'),
    (0, NOW(), NOW(), 5, 'http://example.com/5', 'Sample Article 5');


-- Insert example data for the article_modify_history table
INSERT INTO article_modify_history (article_id, created_at, updated_at, user_id, version_id, modify_type)
VALUES
    (1, NOW(), NOW(), 1, 1, 'CREATE'),
    (2, NOW(), NOW(), 2, 1, 'CREATE'),
    (3, NOW(), NOW(), 3, 1, 'CREATE'),
    (4, NOW(), NOW(), 4, 1, 'CREATE'),
    (5, NOW(), NOW(), 5, 1, 'CREATE');


INSERT INTO article_version_content (deleted, article_id, created_at, editor_id, updated_at, version, content)
VALUES
    (0, 1, NOW(), 1, NOW(), 1, 'This is the content of Article 1'),
    (0, 2, NOW(), 2, NOW(), 1, 'This is the content of Article 2'),
    (0, 3, NOW(), 3, NOW(), 1, 'This is the content of Article 3'),
    (0, 4, NOW(), 4, NOW(), 1, 'This is the content of Article 4'),
    (0, 5, NOW(), 5, NOW(), 1, 'This is the content of Article 5');
