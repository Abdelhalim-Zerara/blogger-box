export interface Category {
  id: string;
  name: string;
}

export type CategoryCreateInputWithIsActive = Omit<Category, "id">&{isActive: boolean;};
export type CategoryCreateInput=Omit<Category, "id">;

const category:
  CategoryCreateInputWithIsActive = {
  name:'Health',
  isActive:true,
};

