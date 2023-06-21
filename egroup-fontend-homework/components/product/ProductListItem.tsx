import { Button, TableCell, TableRow } from "@mui/material";

type Props = {
  desc: string;
  price: number;
  stock: number;
  index: number;
  deleteProduct(index: number): void;
};

const ProductListItem: React.FC<Props> = (props) => {
  const deleteProduct = () => {
    props.deleteProduct(props.index);
  };
  return (
    <TableRow>
      <TableCell>{props.desc}</TableCell>
      <TableCell>{props.price}</TableCell>
      <TableCell>{props.stock}</TableCell>
      <TableCell>
        <Button variant="contained">修改</Button>
        <Button variant="contained" onClick={deleteProduct}>刪除</Button>
      </TableCell>
    </TableRow>
  );
};

export default ProductListItem;
