import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { CategoryService } from '../../services/category.service';
import { Category } from '../../models/category';

@Component({
  selector: 'app-category-table',
  templateUrl: './category-table.component.html',
  styleUrls: ['./category-table.component.css'],
  providers: [CategoryService]
})
export class CategoryTableComponent implements OnInit{

  categories: Category[] = [];

  constructor(private categoryService: CategoryService){}

  displayedColumns = ['name'];
  dataSource = new MatTableDataSource<Category>(this.categories);


  ngOnInit(){
    this.categoryService.getCategories().subscribe((res)=>{
      this.categories = res;
      this.dataSource = new MatTableDataSource<Category>(this.categories);
    });
  }
}
