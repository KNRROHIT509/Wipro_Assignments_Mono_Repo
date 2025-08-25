import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

export interface Todo {
  id: number;
  title: string;
  completed: boolean;
  isEditing: boolean;
}

@Component({
  selector: 'app-todo',
  imports: [CommonModule,
    MatToolbarModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule,
    MatListModule,
    MatDividerModule,
    ReactiveFormsModule,
    FormsModule],
  templateUrl: './to-do.component.html',
  styleUrl: './to-do.component.css'
})
export class TodoComponent {
  newTodoTitle: string = '';

  todos: Todo[] = [
    { id: 1, title: 'Finish notes', completed: false, isEditing: false },
    { id: 2, title: 'Practice Spring Boot', completed: true, isEditing: false },
    { id: 3, title: 'Edit code', completed: false, isEditing: false },
  ];

  private nextId: number = 4;
editedTitle: any;

  addTask(): void {
    const title = this.newTodoTitle.trim();
    if (title) {
      const newTodo: Todo = {
        id: this.nextId++,
        title: title,
        completed: false,
        isEditing: false,
      };
      this.todos.unshift(newTodo);
      this.newTodoTitle = '';
    }
  }

  deleteTask(id: number): void {
    this.todos = this.todos.filter(todo => todo.id !== id);
  }

  toggleEdit(todo: Todo): void {
    todo.isEditing = !todo.isEditing;
  }

  saveTask(todo: Todo, newTitle: string): void {
    todo.title = newTitle.trim();
    todo.isEditing = false;
  }

}