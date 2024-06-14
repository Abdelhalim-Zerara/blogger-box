import { Category } from "./category";
export type PostCreateInput=Omit<Post, "id">;

export interface Post {
  id: string;
  title: string;
  content: string;
  createdDate: Date;
  category: Category;
}