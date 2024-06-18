import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  @Output() toggle = new EventEmitter<boolean>();
  isSidebarClosed = false;
  toggleSidebar() {
    this.isSidebarClosed = !this.isSidebarClosed;
    this.toggle.emit(this.isSidebarClosed);
  }
}
