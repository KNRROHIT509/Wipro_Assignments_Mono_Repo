import { Component } from '@angular/core';
import { MatGridListModule } from '@angular/material/grid-list';  
import { MatCardModule } from '@angular/material/card';            
import { MatIconModule } from '@angular/material/icon';            
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { MatSelectModule } from '@angular/material/select';


@Component({
  selector: 'app-cards',
  imports: [MatGridListModule,MatCardModule,MatIconModule,CommonModule,FormsModule,MatFormFieldModule,MatSelectModule],
  templateUrl: './cards.component.html',
  styleUrl: './cards.component.css'
})
export class CardsComponent {
  movies = [
  { title: "Mission Impossible: Final Reckoning", poster: "posters/mi.jpg", genre: "Crime", rating: 5, description: "Hunt and the IMF pursue a dangerous AI called the Entity that's infiltrated global intelligence. With governments and a figure from his past in pursuit, Hunt races to stop it from forever changing the world." },
  { title: "The Fantastic Four: First Steps", poster: "posters/f4.jpg", genre: "Drama", rating: 4, description: "Forced to balance their roles as heroes with the strength of their family bond, the Fantastic Four must defend Earth from a ravenous space god called Galactus and his enigmatic herald, the Silver Surfer." },
  { title: "Interstellar", poster: "posters/is.jpg", genre: "Sci-Fi", rating: 5, description: "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans." },
  
];
filteredMovies = this.movies;
  selectedGenre = 'All';
  genres = ['All', 'Sci-Fi', 'Drama', 'Crime'];
  cols = 3;  

  constructor(private breakpointObserver: BreakpointObserver) {
    this.breakpointObserver.observe([Breakpoints.Handset])
      .subscribe(result => {
        this.cols = result.matches ? 1 : 3;
      });
  }

  filterMovies() {
    this.filteredMovies = this.selectedGenre === 'All'
      ? this.movies
      : this.movies.filter(m => m.genre === this.selectedGenre);
  }

  getAverageRating(): number {
    if (this.filteredMovies.length === 0) return 0;
    const sum = this.filteredMovies.reduce((total, m) => total + m.rating, 0);
    return sum / this.filteredMovies.length;
  }
}
