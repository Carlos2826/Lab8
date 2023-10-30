DELIMITER //
CREATE PROCEDURE `EliminarProducto`(
    IN p_id INT
)
BEGIN
    DELETE FROM productos WHERE id = p_id;
END//
DELIMITER ;
chichemes