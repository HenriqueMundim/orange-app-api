CREATE TABLE category_project(
  id SERIAL PRIMARY KEY NOT NULL,
  project_id INTEGER NOT NULL,
  category_id INTEGER NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id),
  FOREIGN KEY (category_id) REFERENCES categories (id)
);