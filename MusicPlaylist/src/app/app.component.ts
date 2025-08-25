import { Component } from '@angular/core';
import { NgFor, NgClass } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

interface Song {
  name: string;
  photo: string;
  artist: string;
  album: string;
  duration: string;
  rating: number;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    NgFor,
    NgClass,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  songs: Song[] = [
    { 
      name: 'Rise Up',
      photo: 'albums/song1.jpg', 
      artist: 'The FatRat', 
      album: 'Rise Up', 
      duration: '3:42', 
      rating: 4.8 },
    { 
      name: 'Parano', 
      photo: 'albums/song2.jpg',
      artist: 'Frozy', 
      album: 'Winter Tales', 
      duration: '2:55', 
      rating: 4.3 },
    {  
    name: "Neighbourhood", 
    photo: 'albums/song3.jpg',
    artist: "Reflections", 
    album: "The Color Clear", 
    duration: "4:15", 
    rating: 4.1, 
    
  },
  { 
    name: "All Time Low", 
    photo: 'albums/song4.jpg',
    artist: "Jon Bellion", 
    album: "The Human Condition", 
    duration: "3:37", 
    rating: 4.9, 
  },
  { 
    name: "KU LO SA", 
    photo: 'albums/song5.jpg',
    artist: "Camilo Cabello", 
    album: "Familia", 
    duration: "2:48", 
    rating: 4.6, 
  },
  { 
    name: "Without Me", 
    photo: 'albums/song6.jpg',
    artist: "Halsey", 
    album: "Manic", 
    duration: "3:21", 
    rating: 4.7, 
  }
  ];

  filterArtist = '';
  filterAlbum = '';

  filteredSongs() {
    return this.songs.filter(song =>
      (this.filterArtist ? song.artist.toLowerCase().includes(this.filterArtist.toLowerCase()) : true) &&
      (this.filterAlbum ? song.album.toLowerCase().includes(this.filterAlbum.toLowerCase()) : true)
    );
  }
}