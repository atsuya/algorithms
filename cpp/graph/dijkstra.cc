#include "dijkstra.h"
#include "vertex.h"

#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

const int32_t kInfinity = 100000;

void Dijkstra::Run(const Vertex* start, const Vertex* goal) {
  std::cout << "Finding the shortest path: [" << start->GetName() << ", "
            << goal->GetName() << "]\n";

  vertices_to_visit_.clear();
  for (auto& vertex : kVertices) {
    distances_[vertex.first] = kInfinity;
    previous_[vertex.first] = "";

    std::cout << "Adding to verticies to visit: " << vertex.first << "\n";
    vertices_to_visit_.insert({vertex.first, nullptr});
  }
  std::cout << "Vertices to visit: " << vertices_to_visit_.size() << "\n";

  // source
  distances_[start->GetName()] = 0;

  while (vertices_to_visit_.size() > 0) {
    auto next = this->MinimumDistance();
    std::cout << "Next: " << next << "\n";

    std::cout << "Vertices to visit [before]: " << vertices_to_visit_.size()
              << "\n";
    vertices_to_visit_.erase(next);
    std::cout << "Vertices to visit [after]: " << vertices_to_visit_.size()
              << "\n";

    // check if we reached the goal
    if (next == goal->GetName()) {
      std::cout << "reached the goal: " << next << "\n";
    }

    for (auto& neighbor : this->graph_[next]) {
      auto updated_distance = distances_[next] + neighbor.second;
      if (updated_distance < distances_[neighbor.first]) {
        distances_[neighbor.first] = updated_distance;
        previous_[neighbor.first] = next;
      }
    }
  }
}

void Dijkstra::Initialize() {
  graph_[kVertexA->GetName()] = {
      {kVertexB->GetName(), 6},
      {kVertexD->GetName(), 3},
  };
  graph_[kVertexB->GetName()] = {
      {kVertexA->GetName(), 6},
      {kVertexC->GetName(), 3},
      {kVertexE->GetName(), 1},
  };
  graph_[kVertexC->GetName()] = {
      {kVertexB->GetName(), 3},
      {kVertexF->GetName(), 1},
  };
  graph_[kVertexD->GetName()] = {
      {kVertexA->GetName(), 3},
      {kVertexE->GetName(), 1},
      {kVertexG->GetName(), 9},
  };
  graph_[kVertexE->GetName()] = {
      {kVertexB->GetName(), 1},
      {kVertexD->GetName(), 1},
      {kVertexF->GetName(), 7},
      {kVertexH->GetName(), 4},
  };
  graph_[kVertexF->GetName()] = {
      {kVertexC->GetName(), 1},
      {kVertexE->GetName(), 7},
      {kVertexI->GetName(), 7},
  };
  graph_[kVertexG->GetName()] = {
      {kVertexD->GetName(), 9},
      {kVertexH->GetName(), 2},
  };
  graph_[kVertexH->GetName()] = {
      {kVertexE->GetName(), 4},
      {kVertexG->GetName(), 2},
      {kVertexI->GetName(), 5},
  };
  graph_[kVertexI->GetName()] = {
      {kVertexF->GetName(), 7},
      {kVertexH->GetName(), 5},
  };
}

std::string Dijkstra::MinimumDistance() {
  std::string minimum_vertex = "";
  int32_t minimum_distance = kInfinity;

  for (auto& entry : distances_) {
    std::cout << "Checking distance: " << entry.first << "\n";

    auto ite = vertices_to_visit_.find(entry.first);
    if (ite == vertices_to_visit_.end()) {
      std::cout << "Not in visitted list, skipping\n";
      continue;
    }

    if (entry.second < minimum_distance) {
      minimum_distance = entry.second;
      minimum_vertex = entry.first;
    }
  }

  return minimum_vertex;
}

int main() {
  Dijkstra* dijkstra = new Dijkstra();
  dijkstra->Run(kVertexA, kVertexI);
}
