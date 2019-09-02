delimiter $$
create trigger period before insert on test for each row
    begin
        declare s date default '2019-07-01';
        set NEW.p = timestampdiff(DAY,s,NEW.date0);
    end
$$
delimiter ;
