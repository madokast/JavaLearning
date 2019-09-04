create database ichiwan;
use ichiwan;
create table entries(
    id int primary key auto_increment,
    dateDone date not null ,
    name varchar(20) not null ,
    lengthMinute int not null ,
    describing varchar(100),
    deleteBool  tinyint(1) not null default 0
);

# DROP TRIGGER entriesTrig;
# DELIMITER $$
# CREATE TRIGGER entriesTrig BEFORE INSERT ON entries FOR EACH ROW
# BEGIN
#     DECLARE previousId INT;
#     DECLARE firstDate DATE;
#     DECLARE totalM DOUBLE;
#     DECLARE relativeD DOUBLE;
#     IF NEW.id=1 THEN
#         SET NEW.relativeDate = 1;
#         SET NEW.totalMinute = NEW.lengthMinute;
#     ELSE
#         SET firstDate = (SELECT dateDone FROM entries WHERE id=1);
#         SET previousId = (SELECT MAX(ID) FROM entries);
#         SET NEW.relativeDate = timestampdiff(DAY,firstDate,NEW.dateDone) + 1;
#         SET NEW.totalMinute = (SELECT totalMinute FROM entries WHERE id=previousId) + NEW.lengthMinute;
#         SET NEW.id = previousId+1;
#     END IF ;
#     SET totalM = NEW.totalMinute;
#     SET relativeD = NEW.relativeDate;
#     SET NEW.averageMinute = totalM/relativeD;
# END
# $$
# DELIMITER ;



