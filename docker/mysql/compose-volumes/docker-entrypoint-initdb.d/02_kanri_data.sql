USE kanrichan;

-- Positionデータ挿入
INSERT INTO `position` (position_name)
VALUES ('株主'), ('課長');

-- Genderデータ挿入
INSERT INTO gender (gender_name)
VALUES ('男'), ('女');

-- Employeeデータ挿入 (position_id と gender_id は適切な値を選択)
INSERT INTO employee (
    emp_name, emp_kana, birth, tel, mail, post_code, address, login_id, pass, position_id, gender_id
)
VALUES (
    'shunsuke', 'hata', '1994-07-10', '09089895656', 'hata@gmail.com', '2890987', 'hataworld',
    'shunsukehata', '0710', 1, 1 -- position_id=1 ('株主'), gender_id=1 ('男')
);

-- Add foreign key constraints after data insertion
ALTER TABLE employee
ADD CONSTRAINT fk_position
FOREIGN KEY (position_id) REFERENCES `position`(position_id);

ALTER TABLE employee
ADD CONSTRAINT fk_gender
FOREIGN KEY (gender_id) REFERENCES gender(gender_id);